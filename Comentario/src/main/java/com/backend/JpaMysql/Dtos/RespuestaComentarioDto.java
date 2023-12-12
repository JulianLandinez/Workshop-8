package com.backend.JpaMysql.Dtos;

public class RespuestaComentarioDto {

    private Long publicacionid;
    private String titulo;

    private String contenido;

    private Long usuarioid;
    private String nombre;

    private String apellido;

    public RespuestaComentarioDto(Long publicacionid, String titulo, String contenido, Long usuarioid, String nombre, String apellido) {
        this.publicacionid = publicacionid;
        this.titulo = titulo;
        this.contenido = contenido;
        this.usuarioid = usuarioid;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public RespuestaComentarioDto() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getPublicacionid() {
        return publicacionid;
    }

    public void setPublicacionid(Long publicacionid) {
        this.publicacionid = publicacionid;
    }
}
