package com.backend.JpaMysql.Exceptions;

import com.backend.JpaMysql.Dtos.ResponseError;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(value = {RedSocialApiException.class})
    public ResponseEntity<ResponseError> handlerRedSocialApiException(RedSocialApiException e){
        ResponseError res=new ResponseError(e.getMessage(),e.getCode().value());
        return new ResponseEntity<ResponseError>(res,e.getCode());

    }

    @ExceptionHandler(value = { NoSuchElementException.class })
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e) {
        ResponseError error=new ResponseError("Error inesperado: " + e.getMessage(), 404);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
