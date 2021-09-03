package com.nugurang.graphql.query;

import com.nugurang.dto.ImageDto;
import com.nugurang.service.ImageService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageQuery implements GraphQLQueryResolver {

    private final ImageService imageService;

    public Optional<ImageDto> getImage(Long id) {
        return imageService.getImage(id).map((entity) -> entity.toDto());
    }

    public Optional<ImageDto> getImageByAddress(String address) {
        return imageService.getImage(address).map((entity) -> entity.toDto());
    }
}
