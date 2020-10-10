@RequiredArgsConstructor
@Service
public class ImageResolver implements GraphQLResolver<Image> {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public ImageResolver() {

    }

    public List<Event> events(Image image, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return eventRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public Event event(Image image, int id) {
        return eventRepository.findById(id);
    }

    public List<User> users(Image image, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return userRepository.findAll(PageRequest.of(page, pageSize))
            .stream()
            .map(Thread::new)
            .collect(Collectors.toList());
    }

    public User user(Image image, int id) {
        return userRepository.findById(id);
    }
}
