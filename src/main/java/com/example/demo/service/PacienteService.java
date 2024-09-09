package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Paciente;

public interface PacienteService {
	Paciente create(Paciente p);
	Paciente update(Paciente p);
	void delete(Long id);
	Optional<Paciente> read(Long id);
	List<Paciente> readAll();
}
