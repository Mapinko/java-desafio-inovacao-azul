package com.desafioinovacaoazul.testeeco3.controller;

import com.desafioinovacaoazul.testeeco3.model.User;
import com.desafioinovacaoazul.testeeco3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//  CRIANDO USUARIO
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

//  LISTAR UM USUÁRIO ESPECIFICO
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) { return userService.getUserById(id);}

//  LISTAR TODOS OS USUÁRIOS
   @GetMapping
    public List<User> getAllUsers() { return userService.getAllUsers();}

//  ATUALIZAR USUÁRIO
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

// DELETAR USUÁRIO
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id); }

}
