@RequiredArgsConstructor
@Service
public class XrefUserTaskResolver implements GraphQLResolver<XrefUserTask> {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public XrefUserTaskResolver() {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public User user(XrefUserTask xrefUserTask) {
        return userRepository.findById(xrefUserTask.getUserId());
    }

    public Task task(XrefUserTask xrefUsertask) {
        return taskRepository.findById(xrefUserTask.getTaskId());
    }
}
