package com.news.feed.service;

import com.news.feed.Domain.ApiCall;

public interface BaseApiCall {

    String callApi(ApiCall apiCall);
}
