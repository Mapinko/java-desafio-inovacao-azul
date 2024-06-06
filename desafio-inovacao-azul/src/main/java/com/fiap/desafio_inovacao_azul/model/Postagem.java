package com.fiap.desafio_inovacao_azul.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "POSTAGENS")
public class Postagem {

    @Id
    @Column(name = "ID_POSTAGEM", nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "CONTEUDO", nullable = false, length = 900)
    private String conteudo;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private Timestamp dataCriacao;

    @Column(name = "STATUS", nullable = false, length = 7)
    private String status;

    @Column(name = "CATEGORIA", nullable = false, length = 25)
    private String categoria;

    @Column(name = "CURTIDAS", nullable = false)
    private int curtidas;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;
}
