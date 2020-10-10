@RequiredArgsConstructor
@Service
public class WorkResolver implements GraphQLResolver<Work> {

    private final ProjectRepository projectRepository;

    public WorkResolver(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Image image(Work work) {
        return projectRepository.findById(work.getProjectId());
    }

}
