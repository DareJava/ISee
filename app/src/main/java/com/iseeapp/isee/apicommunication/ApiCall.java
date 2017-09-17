package com.iseeapp.isee.apicommunication;

import com.iseeapp.isee.apicommunication.response.LoginRequestResponse;
import com.iseeapp.isee.apicommunication.response.TrendingRequestResponse;


public enum ApiCall {
    LOGIN("/api/v1/login", ISeeService.POST, LoginRequestResponse.class),
    LIST_TRENDING("/api/v1/login", ISeeService.GET, TrendingRequestResponse.class);

    private String endpoint;
    private String requestType;
    private Class responseType;

    ApiCall(String endpoint, String requestType, Class responseType) {
        this.endpoint = endpoint;
        this.requestType = requestType;
        this.responseType = responseType;
    }
}

