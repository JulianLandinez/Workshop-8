package com.backend.JpaMysql.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario;

    @OneToMany(mappedBy = "publicaciones")
    List<Comentario> comentarios;

    public Publicacion(String titulo, String contenido,Usuario usuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.usuario=usuario;
    }

    public Publicacion() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
