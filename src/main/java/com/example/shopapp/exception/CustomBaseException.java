package com.example.shopapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public class CustomBaseException extends RuntimeException{
    private HttpStatus status;
    private SimpleResponse simpleResponse;
}
