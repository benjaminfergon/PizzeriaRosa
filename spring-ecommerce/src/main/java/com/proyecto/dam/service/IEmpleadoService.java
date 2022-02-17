package com.proyecto.dam.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.dam.model.Empleado;

public interface IEmpleadoService {

	public Empleado save(Empleado empleado);

	public Optional<Empleado> get(Integer id);

	public void update(Empleado empleado);

	public void delete(Integer id);

	public List<Empleado> findAll();

}
