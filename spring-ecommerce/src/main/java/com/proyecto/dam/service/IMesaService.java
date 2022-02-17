package com.proyecto.dam.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.dam.model.Mesa;

public interface IMesaService {
	public Mesa save(Mesa mesa);

	public Optional<Mesa> get(Integer id);

	public void update(Mesa mesa);

	public void delete(Integer id);

	public List<Mesa> findAll();
}
