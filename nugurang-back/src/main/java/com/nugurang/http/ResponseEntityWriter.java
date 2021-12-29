package com.nugurang.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResponseEntityWriter {
    private final ObjectMapper objectMapper;

    public <T> void write(ResponseEntity<T> responseEntity, HttpServletResponse response) throws IOException {
        final var servletServerHttpResponse = new ServletServerHttpResponse(response);
        servletServerHttpResponse.setStatusCode(responseEntity.getStatusCode());
        servletServerHttpResponse.getHeaders().putAll(responseEntity.getHeaders());
        servletServerHttpResponse.getBody().write(objectMapper.writeValueAsBytes(responseEntity.getBody()));
        servletServerHttpResponse.getBody().flush();
    }
}
