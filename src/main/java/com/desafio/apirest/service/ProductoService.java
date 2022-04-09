package com.desafio.apirest.service;

import java.util.Date;

import com.desafio.apirest.model.CrearProducto;
import com.desafio.apirest.model.Producto;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    public Producto generarProducto(CrearProducto crearProducto) {
        Producto producto = new Producto();
        producto.setNombre(crearProducto.getNombre());
        producto.setDescripcion(crearProducto.getDescripcion());
        producto.setPrecio(crearProducto.getPrecio());
        producto.setFechaCreacion(new Date());

        return producto;
    }
}
