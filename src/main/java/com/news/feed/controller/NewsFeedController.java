package com.news.feed.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.news.feed.Domain.FetchNewsRequest;
import com.news.feed.Domain.NewsFeedException;
import com.news.feed.Domain.NewsOrgResponse;
import com.news.feed.service.NewsFeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/fastAndFurious")
public class NewsFeedController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    NewsFeedService newsFeedService;

    @PostMapping("/fetch")
    @CrossOrigin("*")
    public ResponseEntity<NewsOrgResponse> fetchNews(@RequestBody FetchNewsRequest request) throws JsonProcessingException {
        log.info("request {} "+request);

        return ResponseEntity.ok(newsFeedService.fetchNews(request));
    }



}
