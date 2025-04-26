package com.eustachecode.eCommerce_java_app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/eCom")
public class UserController {
    @GetMapping
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("Welcome to Eustache Commerce Java App");
    }
}
