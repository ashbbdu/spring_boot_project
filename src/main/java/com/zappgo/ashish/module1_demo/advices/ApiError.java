package com.zappgo.ashish.module1_demo.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
}
