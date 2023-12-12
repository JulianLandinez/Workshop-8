package com.backend.JpaMysql.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario2;

    @ManyToOne(optional = false)
    @JsonBackReference
    Publicacion publicaciones;

    public Comentario(String contenido, Usuario usuario2, Publicacion publicaciones) {
        this.contenido = contenido;
        this.usuario2 = usuario2;
        this.publicaciones = publicaciones;
    }

    public Comentario() {
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public Publicacion getPublicaciones() {
        return publicaciones;
    }

    public String getContenido() {
        return contenido;
    }








}
