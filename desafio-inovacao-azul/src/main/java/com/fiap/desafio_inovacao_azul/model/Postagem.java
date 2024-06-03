package com.fiap.desafio_inovacao_azul.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "POSTAGENS")
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_POSTAGEM")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "TITULO", nullable = false, length = 30)
    private String titulo;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

    @Column(name = "STATUS", nullable = false, length = 7)
    private String status;

    @Column(name = "CATEGORIA", length = 25)
    private String categoria;

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    private Set<Comentario> comentarios;
}
