package com.example.finalproject.Core.Exceptions;


import com.example.finalproject.Core.Result.ApiError;
import com.example.finalproject.Core.Result.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleExceptionForField(MethodArgumentNotValidException exception){
        ApiError error=new ApiError(400,"validation error");
        Map<String,String> validationErrors= new HashMap<>();

      if (exception.getFieldErrors().size()>0) {
          for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
              validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
          }
          error.setValidationErrors(validationErrors);
      }

        for (ObjectError objectError : exception.getBindingResult().getGlobalErrors()) {
            validationErrors.put(objectError.getObjectName(),objectError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return error;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult exceptionHandler(Exception e) {
        return new ErrorResult("hata "+e.getMessage());
    }

}
