package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

import com.tweteroo.api.services.TweetService;
import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/tweets")

public class TweetsController {
    final TweetService tweetService;

    TweetsController(TweetService tweetService){
        this.tweetService = tweetService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getTweets(){
        List<TweetModel> tweets = tweetService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserTweets(@PathVariable("userId") Long userId){
        List<TweetModel> tweets = tweetService.findById(userId);

        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO dto){
        Optional<TweetModel> tweet = tweetService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }
}
