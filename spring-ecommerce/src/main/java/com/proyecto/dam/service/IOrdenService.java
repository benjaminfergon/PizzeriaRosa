package com.proyecto.dam.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.dam.model.Orden;
import com.proyecto.dam.model.Usuario;

public interface IOrdenService {
	List<Orden> findAll();

	Optional<Orden> findById(Integer id);

	Orden save(Orden orden);

	String generarNumeroOrden();

	List<Orden> findByUsuario(Usuario usuario);
}
