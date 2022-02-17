package com.proyecto.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.dam.model.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
