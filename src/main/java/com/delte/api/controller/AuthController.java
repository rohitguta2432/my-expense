package com.delte.api.controller;

import com.delte.api.mapper.UserDto;
import com.delte.api.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author rohit
 * @Date 06/09/21
 **/

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(authenticationService.authenticateUser(userDto), HttpStatus.OK);
    }
}
