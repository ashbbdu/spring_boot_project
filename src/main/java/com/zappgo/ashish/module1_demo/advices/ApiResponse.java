package com.zappgo.ashish.module1_demo.advices;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ApiResponse <T> {
    private LocalDateTime timeStamp;
    private String message = "Success";
    private T data;
    private ApiError error;


    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }
    public ApiResponse(T data ) {
        this(); // this means calling the default constructor
//        this.message = message;
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this(); // this means calling the default constructor
//        this.message = message;
        this.error = error;
    }
}
