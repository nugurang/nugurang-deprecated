@RequiredArgsConstructor
@Service
public class XrefUserBoardResolver implements GraphQLResolver<XrefUserBoard> {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public XrefUserBoardResolver() {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    public User user(XrefUserBoard xrefUserBoard) {
        return userRepository.findById(xrefUserBoard.getUserId());
    }

    public Board board(XrefUserBoard xrefUserBoard) {
        return boardRepository.findById(xrefUserBoard.getBoardId());
    }
}
