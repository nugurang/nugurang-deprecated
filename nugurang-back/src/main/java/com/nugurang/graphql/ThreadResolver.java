@RequiredArgsConstructor
@Service
public class ThreadResolver implements GraphQLResolver<Thread> {

    private final UserRepository userRepository;
    private final XrefserTeamRepository xrefUserTeamRepository;
    private final BoardRepository boardRepository;
    private final EventRepository eventRepository;
    private final ArticleRepository articledRepository;


    public ThreadResolver(UserRepository userRepository,
            XrefserTeamRepository xrefUserTeamRepository,
            BoardRepository boardRepository,
            EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.xrefUserTeamRepository = xrefUserTeamRepository;
        this.boardRepository = boardRepository;
        this.articledRepository = articledRepository;
    }

    public User user(Thread thread) {
        return userRepository.findById(thread.getTeamId());
    }

    public XrefserTeam xrefserTeam(Thread thread) {
        return xrefUserTeamRepository.findById(thread.getEventId());
    }

    public Board board(Thread thread) {
        return boardRepository.findById(thread.getEventId());
    }

    public Event Evebt(Thread thread) {
        return eventRepository.findById(thread.getEventId());
    }

    public List<Article> article(Thread thread, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return articledRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Article article(Thread thread, int id) {
        return articledRepository.findById(id);
    }
}
