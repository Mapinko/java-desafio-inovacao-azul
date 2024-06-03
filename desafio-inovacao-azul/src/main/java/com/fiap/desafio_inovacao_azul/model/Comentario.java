package com.fiap.desafio_inovacao_azul.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "COMENTARIOS")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMENTARIO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "CONTEUDO", nullable = false, length = 900)
    private String conteudo;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "ID_POSTAGEM")
    private Postagem postagem;

    @ManyToOne
    @JoinColumn(name = "ID_INFORMATIVO")
    private Informativo informativo;
}
