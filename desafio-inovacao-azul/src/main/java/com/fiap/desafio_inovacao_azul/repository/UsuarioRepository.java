package com.fiap.desafio_inovacao_azul.repository;

import com.fiap.desafio_inovacao_azul.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
