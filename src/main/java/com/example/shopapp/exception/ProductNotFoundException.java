package com.example.shopapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ProductNotFoundException extends CustomBaseException {

    public ProductNotFoundException() {
        super(HttpStatus.NOT_FOUND, new SimpleResponse(ErrorMessage.PRODUCT_NOT_FOUND.getMessage()));
    }
}
