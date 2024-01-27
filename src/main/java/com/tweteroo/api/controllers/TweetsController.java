package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;

@RestController
@RequestMapping("/tweets")

public class TweetsController {
    final TweetRepository tweetRepository;

    TweetsController(TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }
    
    @GetMapping
    public List<TweetModel> getTweets(){
        return tweetRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public String getUserTweets(){
        return "Em construção!";
    }
}
