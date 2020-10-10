@RequiredArgsConstructor
@Service
public class FollowingResolver implements GraphQLResolver<Following> {

    private final UserRepository fromUserRepository;
    private final UserRepository toUserRepository;

    public FollowingResolver() {

    }

    public List<User> fromUsers(Following following, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return fromUserRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public User fromUser(Following following, int id) {
        return fromUserRepository.findById(id);
    }

    public List<User> toUsers(Following following, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return toUserRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public User toUser(Following following, int id) {
        return toUserRepository.findById(id);
    }
}
