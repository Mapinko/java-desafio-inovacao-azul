package com.fiap.desafio_inovacao_azul.repository;

import com.fiap.desafio_inovacao_azul.model.Informativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformativoRepository extends JpaRepository<Informativo, Long> {
}
