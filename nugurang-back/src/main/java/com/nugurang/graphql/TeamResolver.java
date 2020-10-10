@RequiredArgsConstructor
@Service
public class TeamResolver implements GraphQLResolver<Team> {

    private final ProjectRepository projectRepository;

    public TeamResolver() {

    }

    public List<Project> projects(Team team, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return projectRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Project project(Team team, int id) {
        return projectRepository.findById(id);
    }
}
