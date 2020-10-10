@RequiredArgsConstructor
@Service
public class XrefUserPositionResolver implements GraphQLResolver<XrefUserPosition> {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;

    public XrefUserPositionResolver() {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
    }

    public User user(XrefUserPosition xrefUserPosition) {
        return userRepository.findById(xrefUserPosition.getUserId());
    }

    public Position position(XrefUserPosition xrefUserPosition) {
        return positionRepository.findById(xrefUserPosition.getPositionId());
    }
}
