@RequiredArgsConstructor
@Service
public class BoardResolver implements GraphQLResolver<Board> {

    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;

    public BoardResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User user(Board board) {
        return userRepository.findById(board.getUserId());
    }

    public List<Thread> threads(Board board, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return threadRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Thread thread(Board board, int id) {
        return threadRepository.findById(id);
    }
}
