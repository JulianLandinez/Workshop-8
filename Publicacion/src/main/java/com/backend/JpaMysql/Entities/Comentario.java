package com.backend.JpaMysql.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario2;

    @ManyToOne(optional = false)
    Publicacion publicaciones;

    public String getContenido() {
        return contenido;
    }


}
