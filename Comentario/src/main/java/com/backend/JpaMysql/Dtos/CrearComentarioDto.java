package com.backend.JpaMysql.Dtos;

public class CrearComentarioDto {


    private String contenido;
    private Long usuarioid;
    private Long publicacionid;


    public CrearComentarioDto(String contenido,  Long usuarioid,Long publicacionid) {
        this.contenido = contenido;
        this.usuarioid=usuarioid;
        this.publicacionid=publicacionid;

    }

    public CrearComentarioDto() {
    }

    public Long getPublicacionid() {
        return publicacionid;
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
