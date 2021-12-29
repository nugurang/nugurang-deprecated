package com.nugurang.rest.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@Slf4j
public class AfterSignoutController {

    @Value("${nugurang.addr.front.url}")
    private String frontUrl;

    @RequestMapping("/after-signout")
    public void afterSignout(HttpServletResponse response) throws IOException {
        log.info("signed out");
        response.sendRedirect(frontUrl);
    }
}
