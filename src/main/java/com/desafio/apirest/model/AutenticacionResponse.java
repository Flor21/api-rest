package com.desafio.apirest.model;

public class AutenticacionResponse {

    private String token;

    public AutenticacionResponse() {

    }

    public AutenticacionResponse(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
