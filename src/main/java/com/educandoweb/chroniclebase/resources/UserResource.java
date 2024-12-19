package com.educandoweb.chroniclebase.resources;

import com.educandoweb.chroniclebase.dto.UserDTO;
import com.educandoweb.chroniclebase.entities.Post;
import com.educandoweb.chroniclebase.entities.User;
import com.educandoweb.chroniclebase.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userData) {
        User newUser = userService.insert(userData);
        UserDTO newUserDTO = new UserDTO(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUserDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO userData) {
        User user = userService.update(id, userData);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.getPosts());
    }

}
