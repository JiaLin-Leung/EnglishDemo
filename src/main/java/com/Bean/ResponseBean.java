package com.Bean;

import java.io.Serializable;

public class ResponseBean implements Serializable {

    private String message;
    private String next;
    private String data;
    private String response;
    private String error;

    @Override
    public String toString() {
        return "ResponseBean{" +
                "message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", data='" + data + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
