package com.desafio.apirest.model;

public class CrearProducto {

    private String nombre;

    private String descripcion;

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
