package ru.evgkit.giflib.web;

public class FlashMessage {
    private String message;

    private Status status;

    public static enum Status {
        SUCCESS,
        FAILURE
    }

    public FlashMessage(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }
}
