package com.fiap.desafio_inovacao_azul.service;

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
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> getComentarioById(Long id) {
        return comentarioRepository.findById(id);
    }

    public Comentario updateComentario(Long id, Comentario comentarioDetails) {
        Comentario comentario = comentarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Comentario not found"));
        comentario.setConteudo(comentarioDetails.getConteudo());
        comentario.setDataCriacao(comentarioDetails.getDataCriacao());
        return comentarioRepository.save(comentario);
    }

    public void deleteComentario(Long id) {
        Comentario comentario = comentarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Comentario not found"));
        comentarioRepository.delete(comentario);
    }
}
