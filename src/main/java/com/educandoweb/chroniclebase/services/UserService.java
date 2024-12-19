package com.educandoweb.chroniclebase.services;

import com.educandoweb.chroniclebase.entities.User;
import com.educandoweb.chroniclebase.repository.UserRepository;
import com.educandoweb.chroniclebase.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new ObjectNotFoundException("user not found.");
        }

        return user.get();
    }
}
