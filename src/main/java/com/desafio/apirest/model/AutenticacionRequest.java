package com.desafio.apirest.model;

public class AutenticacionRequest {

    private String nombre;
    private String contrasenia;

    public AutenticacionRequest(String nombre, String contrasenia) {
        super();
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public AutenticacionRequest() {

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
}
