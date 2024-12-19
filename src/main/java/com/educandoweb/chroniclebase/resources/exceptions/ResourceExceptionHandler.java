package com.educandoweb.chroniclebase.resources.exceptions;

import com.educandoweb.chroniclebase.services.exceptions.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e) {
        StandardError err = new StandardError(Instant.now(), e.getStatus().value(), e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(err);
    }
}
