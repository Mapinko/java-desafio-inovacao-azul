package com.fiap.desafio_inovacao_azul.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "INFORMATIVOS")
public class Informativo {

    @Id
    @Column(name = "ID_INFORMATIVO", nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "CONTEUDO", nullable = false, length = 900)
    private String conteudo;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private Timestamp dataCriacao;

    @Column(name = "AUTOR", nullable = false, length = 200)
    private String autor;

    @Column(name = "CATEGORIA", nullable = false, length = 25)
    private String categoria;
}