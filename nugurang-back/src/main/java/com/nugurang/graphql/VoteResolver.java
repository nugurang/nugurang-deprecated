@RequiredArgsConstructor
@Service
public class VoteResolver implements GraphQLResolver<Vote> {

    private final UserRepository userRepository;
    private final ArticleRepository articledRepository;
    private final VoteTypeRepository voteTypeRepository;


    public VoteResolver(UserRepository userRepository,
            ArticleRepository articledRepository,
            VoteTypeRepository voteTypeRepository) {
        this.userRepository = userRepository;
        this.articledRepository = articledRepository;
        this.voteTypeRepository = voteTypeRepository;
    }

    public User user(Vote vote) {
        return userRepository.findById(thread.getUserId());
    }

    public Article article(Vote vote) {
        return articledRepository.findById(thread.getArticleId());
    }

    public VoteType voteType(Vote vote) {
        return voteTypeRepository.findById(thread.getVoteTypeId());
    }

}
