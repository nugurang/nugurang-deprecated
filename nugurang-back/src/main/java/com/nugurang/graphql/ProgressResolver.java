@RequiredArgsConstructor
@Service
public class ProgressResolver implements GraphQLResolver<Progress> {

    private final TaskRepository taskRepository;

    public ProgressResolver() {

    }

    public List<Task> events(Progress progress, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return taskRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Task event(Progress progress, int id) {
        return taskRepository.findById(id);
    }

}
