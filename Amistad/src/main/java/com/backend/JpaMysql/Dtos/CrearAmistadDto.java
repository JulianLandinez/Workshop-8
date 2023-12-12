package com.backend.JpaMysql.Dtos;

import com.backend.JpaMysql.Entities.Usuario;

import java.util.Date;

public class CrearAmistadDto {

    private Long aceptadoPor;

    private Boolean isaceptado;

    private Date desde;

    private Long solicitante;

    private long solicitado;

    public CrearAmistadDto(Boolean isaceptado, Date desde, long solicitante, long solicitado) {
        this.isaceptado = isaceptado;
        this.desde = desde;
        this.solicitante = solicitante;
        this.solicitado = solicitado;
    }

    public CrearAmistadDto() {
    }

    public Long getAceptadoPor() {
        return aceptadoPor;
    }

    public void setAceptadoPor(Long aceptadoPor) {
        this.aceptadoPor = aceptadoPor;
    }

    public Boolean getIsaceptado() {
        return isaceptado;
    }

    public void setIsaceptado(Boolean isaceptado) {
        this.isaceptado = isaceptado;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Long getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Long solicitante) {
        this.solicitante = solicitante;
    }

    public long getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(long solicitado) {
        this.solicitado = solicitado;
    }
}
