package com.sample.sampletest.exceptions;


public class CustomException extends RuntimeException{

    CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

}
