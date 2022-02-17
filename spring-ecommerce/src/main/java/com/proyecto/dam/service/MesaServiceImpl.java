package com.proyecto.dam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dam.model.Mesa;
import com.proyecto.dam.repository.IMesaRepository;

@Service
public class MesaServiceImpl implements IMesaService {
	@Autowired
	private IMesaRepository mesaRepository;

	@Override
	public Mesa save(Mesa mesa) {
		return mesaRepository.save(mesa);
	}

	@Override
	public Optional<Mesa> get(Integer id) {
		return mesaRepository.findById(id);
	}

	@Override
	public void update(Mesa mesa) {
		mesaRepository.save(mesa);

	}

	@Override
	public void delete(Integer id) {
		mesaRepository.deleteById(id);

	}

	@Override
	public List<Mesa> findAll() {
		return mesaRepository.findAll();
	}

}
