@RequiredArgsConstructor
@Service
public class NotificationResolver implements GraphQLResolver<Notification> {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public NotificationResolver() {

    }

    public List<User> users(Notification notification, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return userRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Event user(Notification notification, int id) {
        return userRepository.findById(id);
    }

    public List<Article> articles(Notification notification, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return articleRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public User article(Notification notification, int id) {
        return articleRepository.findById(id);
    }
}
