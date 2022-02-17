package com.proyecto.dam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dam.model.Empleado;
import com.proyecto.dam.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public Empleado save(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public Optional<Empleado> get(Integer id) {
		return empleadoRepository.findById(id);
	}

	@Override
	public void update(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public void delete(Integer id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

}
