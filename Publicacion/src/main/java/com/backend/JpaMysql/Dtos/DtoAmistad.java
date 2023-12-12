package com.backend.JpaMysql.Dtos;

public class DtoAmistad {

    private String titulo;

    private String contenido;


    private String solicitado;


    public DtoAmistad(String titulo, String contenido, String solicitado) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.solicitado = solicitado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getSolicitado() {
        return solicitado;
    }
}
