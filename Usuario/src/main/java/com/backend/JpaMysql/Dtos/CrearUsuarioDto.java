package com.backend.JpaMysql.Dtos;

import java.io.Serializable;

public class CrearUsuarioDto implements Serializable {
    private Long i;

    private String nombre;

    private String apellido;

    private String direccion;

    private Integer edad;

    public CrearUsuarioDto(String nombre, String apellido, String direccion, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
    }

    public CrearUsuarioDto() {
    }

    public Long getI() {
        return i;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
