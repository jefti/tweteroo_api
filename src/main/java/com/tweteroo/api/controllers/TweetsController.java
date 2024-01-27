package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Optional<TweetModel> getUserTweets(@PathVariable("userId") Long id){
        Optional<TweetModel> tweets = tweetRepository.findById(id);

        if(!tweets.isPresent()){
            return Optional.empty();
        }

        return Optional.of(tweets.get());
    }
}
