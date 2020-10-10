@RequiredArgsConstructor
@Service
public class EventResolver implements GraphQLResolver<Event> {

    private final ImageRepository imageRepository;
    private final ProjectRepository projectRepository;
    private final ThreadRepository threadRepository;

    public EventResolver(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image image(Event event) {
        return imageRepository.findById(event.getImageId());
    }

    public List<Project> projects(Event event, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return projectRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Project project(Event event, int id) {
        return projectRepository.findById(id);
    }

    public List<Thread> threads(Event event, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return threadRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Thread thread(Event event, int id) {
        return threadRepository.findById(id);
    }
}
