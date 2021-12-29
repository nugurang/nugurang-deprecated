package com.nugurang.oauth2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

public class OAuth2RestSecurityContextRepository implements SecurityContextRepository {
    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        String jwtString = requestResponseHolder.getRequest().getHeader("Authorization");
        return null;
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        String jwtString = "hello";
        response.setHeader("Authorization", jwtString);
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return false;
    }
}
