package com.nugurang.graphql.resolver;

import com.nugurang.dao.PositionDao;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.PositionDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PositionResolver implements GraphQLResolver<PositionDto> {
    private final PositionDao positionDao;

    public Optional<ImageDto> image(PositionDto positionDto) {
        return Optional.ofNullable(
            positionDao
            .findById(positionDto.getId())
            .get()
            .getImage()
        )
        .map((entity) -> entity.toDto());
    }
}
