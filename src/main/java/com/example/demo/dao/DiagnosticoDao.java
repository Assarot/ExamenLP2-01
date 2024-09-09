package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Diagnostico;

public interface DiagnosticoDao {
	Diagnostico create(Diagnostico d);
	Diagnostico update(Diagnostico d);
	void delete(Long id);
	Optional<Diagnostico> read(Long id);
	List<Diagnostico> readAll();
}
