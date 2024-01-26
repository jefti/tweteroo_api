package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")

public class UsersController {
    
    @GetMapping
    public String getUsers(){
        return "Em construção!";
    }
}
