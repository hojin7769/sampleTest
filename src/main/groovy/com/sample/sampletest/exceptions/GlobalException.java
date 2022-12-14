package com.sample.sampletest.exceptions;


import com.sample.sampletest.responses.BasicResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Collections;

//@ControllerAdvice(basePackages = {"com.sample.sampletest.API"})
@RestControllerAdvice
public class GlobalException{

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ResponseEntity<?> handleSqlException(Exception ex) {
        String msg = ex.getMessage();
        if (ex.getCause() != null) {
            msg = ex.getCause().getMessage();
        }
        if (ex instanceof DbActionExecutionException) {
            if (ex.getCause().getCause() != null) {
                msg = ex.getCause().getCause().getMessage();
            }
        }

        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).message(msg).result(Collections.emptyList()).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).result(Collections.emptyList())
                .build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }

}
