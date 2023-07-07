package com.sohaib.controllers;


import com.sohaib.dao.Services.UserService;
import com.sohaib.dto.CredentialsDto;
import com.sohaib.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sohaib.security.conf.UserAuthProvider;

@RestController
public class AuthenticationController {



    @Autowired
    UserService userService;

    @Autowired
    UserAuthProvider userAuthProvider;

    @PostMapping("/auth")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.ok(user);
    }

}
