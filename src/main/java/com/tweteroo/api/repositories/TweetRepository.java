package com.tweteroo.api.repositories;
import com.tweteroo.api.models.TweetModel;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    
}
