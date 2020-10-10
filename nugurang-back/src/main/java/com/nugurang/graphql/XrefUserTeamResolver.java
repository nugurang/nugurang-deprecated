@RequiredArgsConstructor
@Service
public class XrefUserTeamResolver implements GraphQLResolver<XrefUserTeam> {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public XrefUserTeamResolver() {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    public User user(XrefUserTeam xrefUserTeam) {
        return userRepository.findById(xrefUserTeam.getUserId());
    }

    public Team team(XrefUserTeam xrefUserteam) {
        return teamRepository.findById(xrefUserTeam.getTeamId());
    }
}
