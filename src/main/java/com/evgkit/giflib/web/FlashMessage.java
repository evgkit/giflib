package com.evgkit.giflib.web;

public class FlashMessage {
    private String message;
    private Status status;

    public static enum Status {
        SUCCESS,
        INFO,
        FAILURE
    }

    public FlashMessage(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
