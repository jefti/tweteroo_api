package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {
    final TweetRepository tweetRepository;

    TweetService (TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }

    public List<TweetModel> findAll() {
		return tweetRepository.findAll();
	}
		
	public Optional<TweetModel> findById(Long id) {
		return tweetRepository.findById(id);
	}

    public TweetModel save(TweetDTO tweetDTO){
        TweetModel tweet = new TweetModel(tweetDTO);
        return tweetRepository.save(tweet);
    }
}
