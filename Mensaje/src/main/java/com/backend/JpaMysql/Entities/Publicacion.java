package com.backend.JpaMysql.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String titulo;

    @Column(length = 100)
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario;

    @OneToMany(mappedBy = "publicaciones")
    @JsonManagedReference
    List<Comentario> comentarios;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
