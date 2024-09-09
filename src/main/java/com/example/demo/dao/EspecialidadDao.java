package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Especialidad;

public interface EspecialidadDao {
	Especialidad create(Especialidad e);
	Especialidad update(Especialidad e);
	void delete(Long id);
	Optional<Especialidad> read(Long id);
	List<Especialidad> readAll();
}
