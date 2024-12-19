package com.educandoweb.chroniclebase.resources;

import com.educandoweb.chroniclebase.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User u1 = new User("1", "Maria Brown", "maria@gmail.com");
        User u2 = new User("2", "Alex Green", "alex@gmail.com");

        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(u1, u2));
    }

}
