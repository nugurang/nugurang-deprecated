@RequiredArgsConstructor
@Service
public class UserResolver implements GraphQLResolver<User> {

    private final ImageRepository imageRepository;
    private final BoardRepository blogRepository;
    private final ThreadRepository threadRepository;
    private final ArticleRepository articledRepository;
    private final FollowingRepository followingRepository;
    private final FollowingRepository followerRepository;
    private final NotificationRepository notificationRepository;


    public UserResolver(ImageRepository imageRepository, BoardRepository blogRepository) {
        this.imageRepository = imageRepository;
        this.blogRepository = blogRepository;
    }

    public Image image(User user) {
        return imageRepository.findById(thread.getTeamId());
    }

    public Board blog(User user) {
        return blogRepository.findById(thread.getEventId());
    }

    public List<Thread> threads(User user, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return threadRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Thread thread(User user, int id) {
        return threadRepository.findById(id);
    }

    public List<Article> articles(User user, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return articledRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Article article(User user, int id) {
        return articledRepository.findById(id);
    }

    public List<Following> followings(User user, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return followingRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Following following(User user, int id) {
        return followingRepository.findById(id);
    }

    public List<Following> Followers(User user, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return followerRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Following Follower(User user, int id) {
        return followerRepository.findById(id);
    }

    public List<Notification> threads(User user, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return notificationRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Notification thread(User user, int id) {
        return notificationRepository.findById(id);
    }
}
