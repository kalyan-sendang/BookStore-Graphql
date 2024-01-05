package com.tests.graphql.utils;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseWrapper<T> {

    private String message;
    private Integer statusCode;

    private boolean success = false;

    private T response;


}
