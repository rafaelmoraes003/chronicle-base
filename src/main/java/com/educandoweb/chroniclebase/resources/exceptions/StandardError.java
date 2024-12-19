package com.educandoweb.chroniclebase.resources.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

public class StandartError implements Serializable {
    private Instant timestamp;
    private HttpStatus status;
    private String message;

    public StandartError(Instant timestamp, HttpStatus status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
