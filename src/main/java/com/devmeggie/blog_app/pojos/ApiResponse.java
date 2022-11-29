package com.devmeggie.blog_app.pojos;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private Integer status;
    private T data;


}
