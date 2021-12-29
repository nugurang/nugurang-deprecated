package com.nugurang.oauth2;

import com.nugurang.dto.RestResponseDto;
import com.nugurang.http.ResponseEntityWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuth2RestAccessDeniedHandler implements AccessDeniedHandler {

    ResponseEntityWriter responseEntityWriter;

    @Override
    public void handle(
        HttpServletRequest request,
        HttpServletResponse response,
        AccessDeniedException accessDeniedException
    ) throws IOException, ServletException {
        log.info("AccessDeniedHandler");
        final var responseDto = RestResponseDto.builder()
                .data(Optional.empty())
                .errors(Optional.of(List.of(
                        RestResponseDto.Error
                                .builder()
                                .message(accessDeniedException.getMessage())
                                .extensions(Optional.of(
                                        RestResponseDto.Error.ErrorExtension.builder().type(accessDeniedException.getClass().getSimpleName()).build()
                                ))
                                .build()
                )))
                .build();

        final var responseEntity = new ResponseEntity<>(responseDto, HttpStatus.FORBIDDEN);
        responseEntityWriter.write(responseEntity, response);
    }
}
