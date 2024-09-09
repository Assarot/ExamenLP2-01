package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Diagnostico;

public interface DiagnosticoService {
	Diagnostico create(Diagnostico d);
	Diagnostico update(Diagnostico d);
	void delete(Long id);
	Optional<Diagnostico> read(Long id);
	List<Diagnostico> readAll();
}
