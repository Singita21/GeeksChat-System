package com.Project.SpringAngular.model;

public class Response {
    private String statusCode;
    private String message;


    public Response(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Response() {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
