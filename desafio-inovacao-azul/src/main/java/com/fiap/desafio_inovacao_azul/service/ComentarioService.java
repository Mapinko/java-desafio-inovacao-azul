package com.fiap.desafio_inovacao_azul.service;

import com.fiap.desafio_inovacao_azul.exception.ResourceNotFoundException;
import com.fiap.desafio_inovacao_azul.model.Comentario;
import com.fiap.desafio_inovacao_azul.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario createComentario(Comentario comentario) {
        if (comentario.getId() == null) {
            comentario.setId(generateUniqueId());
        }
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> getComentarioById(Long id) {
        return Optional.ofNullable(comentarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentário não encontrado com o ID: " + id)));
    }

    public Comentario updateComentario(Long id, Comentario comentarioDetails) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentário não encontrado com o ID: " + id));
        comentario.setConteudo(comentarioDetails.getConteudo());
        comentario.setDataCriacao(comentarioDetails.getDataCriacao());
        comentario.setInformativo(comentarioDetails.getInformativo());
        comentario.setPostagem(comentarioDetails.getPostagem());
        comentario.setUsuario(comentarioDetails.getUsuario());
        return comentarioRepository.save(comentario);
    }

    public void deleteComentario(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentário não encontrado com o ID: " + id));
        comentarioRepository.delete(comentario);
    }

    private synchronized Long generateUniqueId() {
        return System.currentTimeMillis() % 100000000L;
    }
}
