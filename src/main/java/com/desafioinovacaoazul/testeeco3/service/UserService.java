package com.desafioinovacaoazul.testeeco3.service;

import com.desafioinovacaoazul.testeeco3.model.User;
import com.desafioinovacaoazul.testeeco3.repository.UserRepository;
import com.desafioinovacaoazul.testeeco3.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with the ID: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with the ID: " + id));

            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setFollowers(userDetails.getFollowers());
            user.setFollowing(userDetails.getFollowing());

            return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with the ID: " + id));

        userRepository.delete(user);
    }
}
