package com.educandoweb.chroniclebase.services;

import com.educandoweb.chroniclebase.dto.UserDTO;
import com.educandoweb.chroniclebase.entities.Post;
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

    public User insert(UserDTO userData) {
        return userRepository.insert(fromDTO(userData));
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(String id, UserDTO userData) {
        User user = findById(id);
        updateData(user, userData);
        return save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    private User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    private void updateData(User user, UserDTO userData) {
        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
    }
}
