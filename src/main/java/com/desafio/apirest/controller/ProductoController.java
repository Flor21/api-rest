package com.desafio.apirest.controller;

import com.desafio.apirest.model.Producto;
import com.desafio.apirest.model.CrearProducto;

import com.desafio.apirest.repository.ProductoRepository;
import com.desafio.apirest.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    @GetMapping()
    public List<Producto> getAllProductos() {
        return repository.findAll();
    }

    @GetMapping("/{idProducto}")
    public Optional<Producto> getUnProducto(@PathVariable Long idProducto) {
        Optional<Producto> producto = repository.findById(idProducto);
        return producto;
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long idProducto) {
        Optional<Producto> producto = repository.findById(idProducto);
        if (producto.isPresent()) {
            repository.delete(producto.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
