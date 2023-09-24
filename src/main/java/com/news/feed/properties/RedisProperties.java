package com.news.feed.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value = "classpath:redisConfig.properties")
@ConfigurationProperties
public class RedisProperties {

    private String hostName;

    private String port;

    private String password;

    private String timeout;
}
