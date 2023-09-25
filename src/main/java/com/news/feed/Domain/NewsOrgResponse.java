package com.news.feed.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsOrgResponse {

    public String status;
    public int totalResults;
    public List<Article> articles;
}
