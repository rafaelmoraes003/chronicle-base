package com.educandoweb.chroniclebase.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {
    private String body;
    private Instant date;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String body, Instant date, AuthorDTO author) {
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
