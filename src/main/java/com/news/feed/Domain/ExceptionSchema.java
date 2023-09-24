package com.news.feed.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionSchema {

    private LocalDateTime time;

    private String errorCode;

    private HttpStatus httpStatus;

    private String errorDescription;

    private String errorSource;


}
