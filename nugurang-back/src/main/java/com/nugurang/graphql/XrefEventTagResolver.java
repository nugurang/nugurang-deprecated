@RequiredArgsConstructor
@Service
public class XrefEventTagResolver implements GraphQLResolver<XrefEventTag> {

    private final EventRepository eventRepository;
    private final TagRepository tagRepository;

    public XrefEventTagResolver() {
        this.eventRepository = eventRepository;
        this.tagRepository = tagRepository;
    }

    public Event event(XrefEventTag xrefEventTag) {
        return eventRepository.findById(xrefEventTag.getEventId());
    }

    public Tag tag(XrefEventTag xrefEventTag) {
        return tagRepository.findById(xrefEventTag.getTagId());
    }
}
