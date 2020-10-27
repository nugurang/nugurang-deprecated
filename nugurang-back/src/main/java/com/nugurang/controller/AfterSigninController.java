package com.nugurang.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AfterSigninController {

    @RequestMapping("/after-signin")
    public void afterSignin(HttpServletResponse response, @CookieValue("JSESSIONID") String jsessionId) throws IOException {
        response.sendRedirect("http://localhost:3000/after-signin/" + jsessionId);
    }
}
