package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Consulta;
import com.example.demo.service.ConsultaService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/consultas")
public class ConsultaController {
	@Autowired 
	private ConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> readAll() {
		try {
			List<Consulta> Consultas = consultaService.readAll();
			if (Consultas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Consultas, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> read(@PathVariable("id") Long id) {
		try {
			Consulta c = consultaService.read(id).get();
			return new ResponseEntity<>(c, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Consulta> create(@Validated @RequestBody Consulta con) {
		//TODO: process POST request
		try {
			Consulta c = consultaService.create(con);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,@Validated @RequestBody Consulta con) {
		Optional<Consulta> c = consultaService.read(id);
		if (c.get().getId()>0) {
			return new ResponseEntity<>(consultaService.update(con), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Consulta> delete(@PathVariable("id") Long id){
		try {
			consultaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
