package com.desafio.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contasenia")
    private String contrasenia;

    @Column(name = "role")
    private String role;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Usuario(String nombre, String contrasenia, String role) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.role = role;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario [contrasenia=" + contrasenia + ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", role="
                + role + "]";
    }

}
