package com.backend.JpaMysql.Dtos;

public class CrearDto {


    private String titulo;

    private String contenido;

    private Long usuarioid;




    public CrearDto() {
    }
    public CrearDto(String titulo, String contenido,long usuarioid) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.usuarioid=usuarioid;



    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Long usuarioid) {
        this.usuarioid = usuarioid;
    }
}
