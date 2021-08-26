package com.nugurang.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class AfterSignoutController {

    @RequestMapping("/after-signout")
    public void afterSignout(HttpServletResponse response) throws IOException {
        log.info("signed out");
        response.sendRedirect("http://localhost:3000/");
    }
}
