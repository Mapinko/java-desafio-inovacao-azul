package com.fiap.desafio_inovacao_azul.repository;

import com.fiap.desafio_inovacao_azul.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
