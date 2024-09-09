package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombres", columnDefinition = "varchar(55)")
	private String nombres;
	@Column(name = "apellidos", columnDefinition = "varchar(55)")
	private String apellidos;
	@Column(name = "fecha_nac", columnDefinition = "date")
	private String fecha_nac;
	@Column(name = "direccion", columnDefinition = "varchar(45)")
	private String direccion;
	@Column(name = "telefono", columnDefinition = "varchar(9)")
	private String telefono;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Consulta> consultas;
}
