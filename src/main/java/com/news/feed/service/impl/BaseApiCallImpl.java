package com.news.feed.service.impl;

import com.news.feed.Domain.ApiCall;
import com.news.feed.service.BaseApiCall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class BaseApiCallImpl implements BaseApiCall {


    @Override
    public String callApi(ApiCall apiCall) {

        WebClient client = WebClient.create();

        log.info("Api call parameter {}",apiCall);

        WebClient.ResponseSpec responseSpec = client.get().uri(apiCall.getBaseUrl() + apiCall.getEndPoint()).retrieve();

        String responseBody = responseSpec.bodyToMono(String.class).block();

        return responseBody;
    }
}
