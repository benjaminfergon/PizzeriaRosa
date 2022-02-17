package com.proyecto.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.dam.model.Producto;


@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

}
