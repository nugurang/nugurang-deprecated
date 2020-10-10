@RequiredArgsConstructor
@Service
public class XrefArticleImageResolver implements GraphQLResolver<XrefArticleImage> {

    private final ArticleRepository articleRepository;
    private final ImageRepository imageRepository;

    public XrefArticleImageResolver() {
        this.articleRepository = articleRepository;
        this.imageRepository = imageRepository;
    }

    public Article article(XrefArticleImage xrefArticleImage) {
        return articleRepository.findById(xrefArticleImage.getArticleId());
    }

    public Image image(XrefArticleImage xrefArticleImage) {
        return imageRepository.findById(xrefArticleImage.getImageId());
    }
}
