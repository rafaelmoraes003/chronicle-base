package com.educandoweb.chroniclebase.resources;

import com.educandoweb.chroniclebase.dto.UserDTO;
import com.educandoweb.chroniclebase.entities.User;
import com.educandoweb.chroniclebase.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> usersDTO = users
                .stream()
                .map(u -> new UserDTO(u))
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(usersDTO);
    }

}
