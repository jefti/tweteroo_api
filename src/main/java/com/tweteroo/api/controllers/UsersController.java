package com.tweteroo.api.controllers;
import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.services.UserService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")

public class UsersController {
    
    final UserService userService;
    UsersController( UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body){
        Optional<UserModel> user = userService.save(body);
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username repetido.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
