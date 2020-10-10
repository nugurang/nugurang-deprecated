@RequiredArgsConstructor
@Service
public class XrefThreadTagResolver implements GraphQLResolver<XrefThreadTag> {

    private final ThreadRepository threadRepository;
    private final TagRepository tagRepository;

    public XrefThreadTagResolver() {
        this.threadRepository = threadRepository;
        this.tagRepository = tagRepository;
    }

    public Thread thread(XrefTaskPosition xrefTaskPosition) {
        return threadRepository.findById(xrefTaskPosition.getThreadId());
    }

    public Tag tag(XrefTaskPosition xrefTaskPosition) {
        return tagRepository.findById(xrefTaskPosition.getTagId());
    }
}
