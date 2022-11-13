package com.example.finalproject.Core.Result;

import lombok.Getter;

@Getter
public class DataResult<T> extends Result{

    private T data;
    public DataResult(T data,Boolean success) {

        super(success);
        this.data=data;
    }

    public DataResult(T data,Boolean success, String message) {
        super(success, message);
        this.data=data;
    }
}
