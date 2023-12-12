package com.backend.JpaMysql.Entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table
public class Amistad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private Boolean isaceptado;

    @Column(nullable = true)
    private Date desde;

    @ManyToOne(optional = false)
    Usuario solicitante;

    @ManyToOne(optional = false)
    Usuario solicitado;
}
