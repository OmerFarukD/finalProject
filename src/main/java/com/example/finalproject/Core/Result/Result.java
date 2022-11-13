package com.example.finalproject.Core.Result;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.Map;

@Data
public class Result {
    private Boolean success;
    private String message;

    public Result(Boolean success) {
        this.success = success;
    }

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}







