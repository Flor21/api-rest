package com.desafio.apirest.model;

public class AutenticacionRequest {

    private String email;
    private String contrasenia;

    public AutenticacionRequest(String email, String contrasenia) {
        super();
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public AutenticacionRequest() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
