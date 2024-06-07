package com.desafioinovacaoazul.testeeco3.controller;

import com.desafioinovacaoazul.testeeco3.DTO.UserResponseDTO;
import com.desafioinovacaoazul.testeeco3.model.User;
import com.desafioinovacaoazul.testeeco3.repository.UserRepository;
import com.desafioinovacaoazul.testeeco3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//  CRIANDO USUARIO
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getFollowers(),
                savedUser.getFollowing()
        );

        return ResponseEntity.status(201).body(responseDTO);
    }

    // Get All Users
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        UserResponseDTO responseDTO = new UserResponseDTO(
                updatedUser.getId(),
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getFollowers(),
                updatedUser.getFollowing()
        );
        return ResponseEntity.ok(responseDTO);
    }

    // Get All Users
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getFollowers(),
                        user.getFollowing()
                ))
                .collect(Collectors.toList());
    }

    // Get Specific User
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserResponseDTO responseDTO = new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFollowers(),
                user.getFollowing()
        );
        return ResponseEntity.ok(responseDTO);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
