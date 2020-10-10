@RequiredArgsConstructor
@Service
public class TaskResolver implements GraphQLResolver<Task> {

    private final WrokRepository workrRepository;
    private final ProgressRepository progressRepository;

    public TaskResolver(WrokRepository workrRepository, ProgressRepository progressRepository) {
        this.workrRepository = workrRepository;
        this.progressRepository = progressRepository;
    }

    public Work work(Task task) {
        return workrRepository.findById(task.getWorkId());
    }

    public Progress progress(Task task) {
        return progressRepository.findById(task.getProgressId());
    }

}
