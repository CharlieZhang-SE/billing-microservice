package com.billing.model;

public class Response<T> {

    private String message;
    private T data;
    private String error;

    // Constructor for success response
    public Response(String message, T data) {
        this.message = message;
        this.data = data;
        this.error = null; // No error in success
    }

    // Constructor for error response
    public Response(String error) {
        this.message = null;
        this.data = null;
        this.error = error;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for data (generic type)
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Getter and Setter for error
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}