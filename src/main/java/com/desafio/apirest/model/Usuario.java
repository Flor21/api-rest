package com.desafio.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contasenia", nullable = false)
    private String contrasenia;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "El Email no puede ser vacio")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario(String nombre, String contrasenia, String role, String email) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.role = role;
        this.email = email;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario [contrasenia=" + contrasenia + ", email=" + email + ", idUsuario=" + idUsuario + ", nombre="
                + nombre + ", role=" + role + "]";
    }

}
