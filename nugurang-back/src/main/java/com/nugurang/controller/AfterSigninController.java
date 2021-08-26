package com.nugurang.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class AfterSigninController {

    @Value("${nugurang.addr.front.url}")
    private String frontUrl;

    @RequestMapping("/after-signin")
    public void afterSignin(HttpServletResponse response, @CookieValue("JSESSIONID") String jsessionId) throws IOException {
        log.info(jsessionId + "signed in");
        response.sendRedirect(frontUrl + "/after-signin/" + jsessionId);
    }
}
