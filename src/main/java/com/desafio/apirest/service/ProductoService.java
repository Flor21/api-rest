package com.desafio.apirest.service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.desafio.apirest.model.CrearProducto;
import com.desafio.apirest.model.Producto;
import com.desafio.apirest.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public Producto generarProducto(CrearProducto crearProducto) {
        Producto producto = new Producto();
        producto.setNombre(crearProducto.getNombre());
        producto.setDescripcion(crearProducto.getDescripcion());
        producto.setPrecio(crearProducto.getPrecio());
        producto.setFechaCreacion(new Date());

        return repository.save(producto);
    }

    public Producto findById(Long idProducto) {
        Optional<Producto> producto = repository.findById(idProducto);
        if (producto.isEmpty())
            throw new NoSuchElementException(Long.toString(idProducto));
        return producto.get();

    }

    public void deleteProducto(Long idProducto) {
        Optional<Producto> producto = repository.findById(idProducto);
        if (producto.isEmpty())
            throw new NoSuchElementException(Long.toString(idProducto));
        repository.delete(producto.get());

    }

}
