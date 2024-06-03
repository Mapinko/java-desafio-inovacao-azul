package com.fiap.desafio_inovacao_azul.service;

import com.fiap.desafio_inovacao_azul.model.Postagem;
import com.fiap.desafio_inovacao_azul.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem createPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public List<Postagem> getAllPostagens() {
        return postagemRepository.findAll();
    }

    public Optional<Postagem> getPostagemById(Long id) {
        return postagemRepository.findById(id);
    }

    public Postagem updatePostagem(Long id, Postagem postagemDetails) {
        Postagem postagem = postagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Postagem not found"));
        postagem.setTitulo(postagemDetails.getTitulo());
        postagem.setDataCriacao(postagemDetails.getDataCriacao());
        postagem.setStatus(postagemDetails.getStatus());
        postagem.setCategoria(postagemDetails.getCategoria());
        return postagemRepository.save(postagem);
    }

    public void deletePostagem(Long id) {
        Postagem postagem = postagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Postagem not found"));
        postagemRepository.delete(postagem);
    }
}
