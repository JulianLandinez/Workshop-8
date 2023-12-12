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
    Long aceptadoPor;

    public Amistad(Boolean isaceptado, Date desde, Usuario solicitante, Usuario solicitado) {
        this.isaceptado = isaceptado;
        this.desde = desde;
        this.solicitante = solicitante;
        this.solicitado = solicitado;
    }

    public Amistad() {
    }

    public Long getId() {
        return id;
    }



    public Boolean getIsaceptado() {
        return isaceptado;
    }



    public Date getDesde() {
        return desde;
    }



    public Usuario getSolicitante() {
        return solicitante;
    }


    public Usuario getSolicitado() {
        return solicitado;
    }


    public void setAceptadoPor(Long aceptadoPor) {
    }


    public Long getAceptadoPor() {
        return aceptadoPor;
    }
}
