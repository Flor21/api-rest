package com.desafio.apirest.controller;

import com.desafio.apirest.model.Producto;
import com.desafio.apirest.model.CrearProducto;
import com.desafio.apirest.repository.ProductoRepository;
import com.desafio.apirest.service.ProductoService;
import com.desafio.apirest.utils.InvalidDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

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
    public ResponseEntity<Object> create(@Valid @RequestBody CrearProducto crearProducto, BindingResult result) {
        if (result.hasErrors())
            throw new InvalidDataException(result);

        Producto producto = service.generarProducto(crearProducto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<Object> getAllProductos() {
        List<Producto> productos = repository.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Object> getUnProducto(@PathVariable Long idProducto) {
        return new ResponseEntity<>(service.findById(idProducto), HttpStatus.OK);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Long idProducto) {
        service.deleteProducto(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
