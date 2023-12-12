package com.backend.JpaMysql.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario emisor;

    @ManyToOne(optional = false)
    Usuario receptor;
}
