package com.backend.JpaMysql.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String direccion;
    @Column
    private Integer edad;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String direccion, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    @OneToMany(mappedBy = "usuario")
    List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "emisor")
    List<Mensaje> mensajesEnviados;

    @OneToMany(mappedBy = "receptor")
    List<Mensaje> mensajesRecibidos;

    @OneToMany(mappedBy = "solicitante")
    List<Amistad> solicirudEnviada;

    @OneToMany(mappedBy = "solicitado")
    List<Amistad> solicitudRecibida;

    @OneToMany(mappedBy = "usuario2")
    List<Comentario> comentarios;


}
