
package com.leyton.domain;

public class GreetingResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GreetingResponse [message=" + message + "]";
    }
}
