package com.desafio.apirest.repository;

import java.util.Optional;

import com.desafio.apirest.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findById(Long idProducto);
}
