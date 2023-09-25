package com.news.feed.Domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpMethod;

import java.util.List;

@Data
@ToString
public class ApiCall {

    private String baseUrl;

    private String endPoint;

    private List<Parameters> pathParams;

    private String requestBody;

    private HttpMethod httpMethod;
}
