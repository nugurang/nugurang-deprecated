package com.nugurang.oauth2;

import com.nugurang.dto.RestResponseDto;
import com.nugurang.http.ResponseEntityWriter;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final ResponseEntityWriter responseEntityWriter;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {
        final var responseDto = RestResponseDto.builder()
                .data(Optional.of(authentication))
                .errors(Optional.empty())
                .build();
        final var responseEntity = new ResponseEntity<>(responseDto, HttpStatus.OK);
        responseEntityWriter.write(responseEntity, response);
    }
}
