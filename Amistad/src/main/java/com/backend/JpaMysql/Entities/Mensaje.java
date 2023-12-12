package com.backend.JpaMysql.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String contenido;

    @ManyToOne(optional = false)
    Usuario emisor;

    @ManyToOne(optional = false)
    Usuario receptor;

    public Mensaje(String contenido, Usuario emisor, Usuario receptor) {
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public Mensaje() {
    }

    public Long getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }


}
