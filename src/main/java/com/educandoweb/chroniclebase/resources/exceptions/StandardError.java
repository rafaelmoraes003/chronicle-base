package com.educandoweb.chroniclebase.resources.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private Instant timestamp;
    private Integer status;
    private String message;

    public StandardError(Instant timestamp, Integer status, String message) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
