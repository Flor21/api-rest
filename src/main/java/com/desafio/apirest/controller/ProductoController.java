package com.desafio.apirest.controller;

import com.desafio.apirest.model.Producto;
import com.desafio.apirest.model.CrearProducto;
import com.desafio.apirest.repository.ProductoRepository;
import com.desafio.apirest.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private ProductoService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> create(@Valid @RequestBody CrearProducto crearProducto) {
        Producto producto = service.generarProducto(crearProducto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllProductos() {
        List<Producto> productos = repository.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Object> getUnProducto(@PathVariable Long idProducto) {
        return new ResponseEntity<>(service.findById(idProducto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Long idProducto) {
        service.deleteProducto(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
