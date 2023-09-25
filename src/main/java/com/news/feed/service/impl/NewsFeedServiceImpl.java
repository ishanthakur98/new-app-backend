package com.news.feed.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.feed.Domain.ApiCall;
import com.news.feed.Domain.FetchNewsRequest;
import com.news.feed.Domain.NewsOrgResponse;
import com.news.feed.service.BaseApiCall;
import com.news.feed.service.NewsFeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class NewsFeedServiceImpl extends BaseService implements NewsFeedService {

    @Autowired
    BaseApiCall baseApiCall;

    @Autowired
    RedisTemplate redisTemplate;

    private static final String REDIS_KEY = "TODAY_NEWS_HOUR";

    @Autowired
    private Environment env;

    @Override
    public NewsOrgResponse fetchNews(FetchNewsRequest request)  {
        log.info("inside service layer fetchNews");
        NewsOrgResponse newsOrgResponse = null;

        newsOrgResponse = fetchNewsFromRedis();
        if(newsOrgResponse!=null){
            log.info("info fetched from redis is "+newsOrgResponse);
            return newsOrgResponse;
        }
        log.info("fetching from api *********************!");

        ApiCall apiCall= new ApiCall();

        apiCall.setBaseUrl("https://newsapi.org/v2/top-headlines?apiKey="+env.getProperty("key"));
        StringBuilder builder = new StringBuilder();
        if(request.getParams() != null &&!request.getParams().isEmpty()){
            request.getParams().forEach(e -> builder.append("&"+e.getKey()+"="+e.getValue()));

        }
        apiCall.setEndPoint(builder.toString());
        String response = baseApiCall.callApi(apiCall);

        newsOrgResponse = generateJsonResponse(response, NewsOrgResponse.class);
        addNewsToRedis(newsOrgResponse);
        return newsOrgResponse;
    }


    protected <T> T fetchNewsFromRedis(){
        T t = null;
        try {
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
             t = (T) redisTemplate.opsForValue().get(REDIS_KEY+String.valueOf(hour));
        }catch (Exception e){
            log.error("{}",e);
        }
        return  t;
    }

    protected  void addNewsToRedis(NewsOrgResponse newsOrgResponse){
        try {
            Calendar rightNow = Calendar.getInstance();
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
            redisTemplate.opsForValue().set(REDIS_KEY+String.valueOf(hour) , newsOrgResponse);
            redisTemplate.expire(REDIS_KEY+String.valueOf(hour), 30 , TimeUnit.MINUTES);
            log.info("saved to redis ");
        }catch (Exception e){
            log.error("{}",e);
        }
    }
}
