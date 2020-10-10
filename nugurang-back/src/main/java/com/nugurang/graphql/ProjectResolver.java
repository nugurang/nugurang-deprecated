@RequiredArgsConstructor
@Service
public class ProjectResolver implements GraphQLResolver<Project> {

    private final TeamRepository teamRepository;
    private final EventRepository eventRepository;
    private final WorkRepository workRepository;

    public ProjectResolver(TeamRepository teamRepository, EventRepository eventRepository) {
        this.teamRepository = teamRepository;
        this.eventRepository = eventRepository;
    }

    public Team team(Project project) {
        return teamRepository.findById(project.getTeamId());
    }

    public Event event(Project project) {
        return eventRepository.findById(project.getEventId());
    }

    public List<Work> works(Project project, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return workRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Work work(Project project, int id) {
        return workRepository.findById(id);
    }
}
