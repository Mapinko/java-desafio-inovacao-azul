package com.fiap.desafio_inovacao_azul.repository;

import com.fiap.desafio_inovacao_azul.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
