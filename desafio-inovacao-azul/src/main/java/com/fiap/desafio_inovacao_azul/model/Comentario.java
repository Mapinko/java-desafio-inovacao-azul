package com.fiap.desafio_inovacao_azul.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "COMENTARIOS")
public class Comentario {

    @Id
    @Column(name = "ID_COMENTARIO", nullable = false)
    private Long id;

    @Column(name = "CONTEUDO", nullable = false, length = 400)
    private String conteudo;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private Timestamp dataCriacao;

    @ManyToOne
    @JoinColumn(name = "ID_INFORMATIVO")
    private Informativo informativo;

    @ManyToOne
    @JoinColumn(name = "ID_POSTAGEM")
    private Postagem postagem;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;
}
