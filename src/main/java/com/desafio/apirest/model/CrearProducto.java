package com.desafio.apirest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearProducto {

    @JsonProperty("precio")
    private String nombre;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("precio")
    private Double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "CrearProducto [descripcion=" + descripcion + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

}
