package com.news.feed.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseService {

    protected <T> T generateJsonResponse(String jsonInput , Class<T> clazz){
        T t = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            t = objectMapper.readValue(jsonInput , clazz);
        }catch (Exception e){
            log.error("{}",e);
        }
        return t;

    }
}
