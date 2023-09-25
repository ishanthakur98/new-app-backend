package com.news.feed.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.news.feed.Domain.FetchNewsRequest;
import com.news.feed.Domain.NewsOrgResponse;

public interface NewsFeedService {

    NewsOrgResponse fetchNews(FetchNewsRequest request) throws JsonProcessingException;
}
