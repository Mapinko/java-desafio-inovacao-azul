package com.fiap.desafio_inovacao_azul.service;

import com.fiap.desafio_inovacao_azul.exception.ResourceNotFoundException;
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
        if (postagem.getId() == null) {
            postagem.setId(generateUniqueId());
        }
        return postagemRepository.save(postagem);
    }

    public List<Postagem> getAllPostagens() {
        return postagemRepository.findAll();
    }

    public Optional<Postagem> getPostagemById(Long id) {
        return Optional.ofNullable(postagemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Postagem não encontrada com o ID: " + id)));
    }

    public Postagem updatePostagem(Long id, Postagem postagemDetails) {
        Postagem postagem = postagemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Postagem não encontrada com o ID: " + id));
        postagem.setTitulo(postagemDetails.getTitulo());
        postagem.setConteudo(postagemDetails.getConteudo());
        postagem.setDataCriacao(postagemDetails.getDataCriacao());
        postagem.setStatus(postagemDetails.getStatus());
        postagem.setCategoria(postagemDetails.getCategoria());
        postagem.setCurtidas(postagemDetails.getCurtidas());
        postagem.setUsuario(postagemDetails.getUsuario());
        return postagemRepository.save(postagem);
    }

    public void deletePostagem(Long id) {
        Postagem postagem = postagemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Postagem não encontrada com o ID: " + id));
        postagemRepository.delete(postagem);
    }

    private synchronized Long generateUniqueId() {
        return System.currentTimeMillis() % 100000000L;
    }
}
