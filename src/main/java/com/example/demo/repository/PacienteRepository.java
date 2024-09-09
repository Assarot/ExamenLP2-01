package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
