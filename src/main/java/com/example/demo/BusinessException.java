package com.example.demo;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    public BusinessException(String errorMessage){
        super(errorMessage);
    }

}
