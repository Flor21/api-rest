package com.desafio.apirest.controller;

import com.desafio.apirest.model.Producto;
import com.desafio.apirest.model.CrearProducto;

import com.desafio.apirest.repository.ProductoRepository;
import com.desafio.apirest.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private ProductoService service;

    @PostMapping()
    public ResponseEntity<Producto> create(@Valid @RequestBody CrearProducto crearProducto) {
        Producto producto = service.generarProducto(crearProducto);
        return ResponseEntity.ok(repository.save(producto));
    }
}
