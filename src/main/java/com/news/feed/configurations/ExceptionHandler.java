package com.news.feed.configurations;

import com.news.feed.Domain.ExceptionSchema;
import com.news.feed.Domain.NewsFeedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NewsFeedException.class)
    public ResponseEntity<Object> customException(NewsFeedException newsFeedException) throws Exception{
        ExceptionSchema exceptionSchema = new ExceptionSchema(LocalDateTime.now(),String.valueOf(HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST,newsFeedException.getErrorDescription(),newsFeedException.getErrorSource());

        return new ResponseEntity<>(exceptionSchema , HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception newsFeedException) throws Exception{
        ExceptionSchema exceptionSchema = new ExceptionSchema(LocalDateTime.now(),String.valueOf(HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST,newsFeedException.getMessage(),newsFeedException.getCause().toString());

        return new ResponseEntity<>(exceptionSchema , HttpStatus.BAD_REQUEST);
    }
}
