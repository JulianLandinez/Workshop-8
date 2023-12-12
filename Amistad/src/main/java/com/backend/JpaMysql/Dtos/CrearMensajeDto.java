package com.backend.JpaMysql.Dtos;

public class CrearMensajeDto {



    private String contenido;
    private Long emisor;

    private Long receptor;
    private Long aceptadoPor;

    public CrearMensajeDto() {

    }

    public CrearMensajeDto(String contenido) {
        this.contenido = contenido;
    }

    public CrearMensajeDto(String contenido, Long emisor, Long receptor) {
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public Long getAceptadoPor() {
        return aceptadoPor;
    }

    public void setAceptadoPor(Long aceptadoPor) {
        this.aceptadoPor = aceptadoPor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getEmisor() {
        return emisor;
    }

    public void setEmisor(Long emisor) {
        this.emisor = emisor;
    }

    public Long getReceptor() {
        return receptor;
    }

    public void setReceptor(Long receptor) {
        this.receptor = receptor;
    }
}
