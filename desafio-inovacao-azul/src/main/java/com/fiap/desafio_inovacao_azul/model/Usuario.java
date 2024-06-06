package com.fiap.desafio_inovacao_azul.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private Long id;

    @Column(name = "NOME_USUARIO", nullable = false, length = 10)
    private String nomeUsuario;

    @Column(name = "EMAIL", nullable = false, length = 255)
    private String email;

    @Column(name = "SENHA", nullable = false, length = 20)
    private String senha;

    @Column(name = "NOME_COMPLETO", nullable = false, length = 200)
    private String nomeCompleto;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private Timestamp dataNascimento;

    @Column(name = "TELEFONE", nullable = false, length = 15)
    private String telefone;

    @Column(name = "SEGUINDO")
    private int seguindo;

    @Column(name = "SEGUIDORES")
    private int seguidores;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Postagem> postagens;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Comentario> comentarios;
}