package com.fiap.desafio_inovacao_azul.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "INFORMATIVOS")
public class Informativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INFORMATIVO")
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 30)
    private String titulo;

    @Column(name = "CONTEUDO", nullable = false, length = 900)
    private String conteudo;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

    @Column(name = "AUTOR", nullable = false, length = 200)
    private String autor;

    @Column(name = "CATEGORIA", length = 25)
    private String categoria;

    @OneToMany(mappedBy = "informativo", cascade = CascadeType.ALL)
    private Set<Comentario> comentarios;
}
