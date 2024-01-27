package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")

public class TweetsController {
    final TweetRepository tweetRepository;

    TweetsController(TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }
    
    @GetMapping
    public ResponseEntity<Object> getTweets(){
        List<TweetModel> tweets = tweetRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getUserTweets(@PathVariable("userId") Long id){
        Optional<TweetModel> tweets = tweetRepository.findById(id);

        if(!tweets.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(tweets.get());
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO dto){
        TweetModel tweet = new TweetModel(dto);
        tweetRepository.save(tweet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
