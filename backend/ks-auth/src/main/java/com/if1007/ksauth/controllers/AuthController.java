package com.if1007.ksauth.controllers;

import com.if1007.ksauth.DTO.User;
import com.if1007.ksauth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> authenticateUser(@RequestBody User user){
        //AuthCredentials credentials = service.authenticate(user.getEmail(), user.getPassword());
        String credentials = service.authenticate(user.getEmail(), user.getPassword());

        return ResponseEntity.ok(credentials);
    }
}
