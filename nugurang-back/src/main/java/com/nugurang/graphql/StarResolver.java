@RequiredArgsConstructor
@Service
public class StarResolver implements GraphQLResolver<Star> {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public StarResolver(UserRepository userRepository, ArticleRepository parentRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    public User user(Star star) {
        return userRepository.findById(article.getUserId());
    }

    public Article article(Star star) {
        return articleRepository.findById(article.getArticleId());
    }

}
