@RequiredArgsConstructor
@Service
public class XrefTaskPositionResolver implements GraphQLResolver<XrefTaskPosition> {

    private final TaskRepository taskRepository;
    private final PositionRepository positionRepository;

    public XrefTaskPositionResolver() {
        this.taskRepository = taskRepository;
        this.positionRepository = positionRepository;
    }

    public Task task(XrefTaskPosition xrefTaskPosition) {
        return taskRepository.findById(xrefTaskPosition.getTaskId());
    }

    public Position position(XrefTaskPosition xrefTaskPosition) {
        return positionRepository.findById(xrefTaskPosition.getPositionId());
    }
}
