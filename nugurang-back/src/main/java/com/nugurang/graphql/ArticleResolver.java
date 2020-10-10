@RequiredArgsConstructor
@Service
public class ArticleResolver implements GraphQLResolver<Article> {

    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;
    private final ArticleRepository parentRepository;

    public ArticleResolver(UserRepository userRepository, ArticleRepository parentRepository) {
        this.userRepository = userRepository;
        this.parentRepository = parentRepository;
    }

    public User user(Article article) {
        return userRepository.findById(article.getUserId());
    }

    public List<Thread> threads(Article article, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return threadRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Thread thread(Article article, int id) {
        return threadRepository.findById(id);
    }

    public Article parent(Article article) {
        return parentRepository.findById(article.getParentId());
    }

}
