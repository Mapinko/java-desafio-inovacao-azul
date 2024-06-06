package com.fiap.desafio_inovacao_azul.controller;

import com.fiap.desafio_inovacao_azul.model.Postagem;
import com.fiap.desafio_inovacao_azul.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @PostMapping
    public Postagem createPostagem(@RequestBody Postagem postagem) {
        return postagemService.createPostagem(postagem);
    }

    @GetMapping
    public List<Postagem> getAllPostagens() {
        return postagemService.getAllPostagens();
    }

    @GetMapping("/{id}")
    public Optional<Postagem> getPostagemById(@PathVariable Long id) {
        return postagemService.getPostagemById(id);
    }

    @PutMapping("/{id}")
    public Postagem updatePostagem(@PathVariable Long id, @RequestBody Postagem postagemDetails) {
        return postagemService.updatePostagem(id, postagemDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePostagem(@PathVariable Long id) {
        postagemService.deletePostagem(id);
    }
}
