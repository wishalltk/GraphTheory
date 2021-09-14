package com.machinecoding.threads;

public class OrderResponse {
    int httpCode;

    public int getHttpCode() {
        return httpCode;
    }

    public OrderResponse setHttpCode(int httpCode) {
        this.httpCode = httpCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public OrderResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    String message;


}
