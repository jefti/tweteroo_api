package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweets")

public class TweetsController {
    @GetMapping
    public String getTweets(){
        return "Em construção!";
    }

    @GetMapping("/user/{userId}")
    public String getUserTweets(){
        return "Em construção!";
    }
}
