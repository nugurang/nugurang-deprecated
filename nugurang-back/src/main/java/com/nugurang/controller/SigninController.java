package com.nugurang.controller;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SigninController {
    @RequestMapping("/signin")
    public ResponseEntity index() {
        return new ResponseEntity<>(new HashMap<String, String>(), HttpStatus.FORBIDDEN);
    }
}
