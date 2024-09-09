package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Diagnostico;
import com.example.demo.service.DiagnosticoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/diagnosticos")
public class DiagnosticoController {
	@Autowired
	private DiagnosticoService diagnosticoService;
	
	@GetMapping
	public ResponseEntity<List<Diagnostico>> readAll() {
		try {
			List<Diagnostico> diagnosticos = diagnosticoService.readAll();
			if (diagnosticos.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(diagnosticos, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostico> read(@PathVariable("id") Long id) {
		try {
			Diagnostico d = diagnosticoService.read(id).get();
			return new ResponseEntity<>(d, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Diagnostico> create(@Validated @RequestBody Diagnostico dia) {
		try {
			Diagnostico d = diagnosticoService.create(dia);
			return new ResponseEntity<>(d, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,@Validated @RequestBody Diagnostico dia) {
		Optional<Diagnostico> d = diagnosticoService.read(id);
		if (d.get().getId()>0) {
			return new ResponseEntity<>(diagnosticoService.update(dia), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Diagnostico> delete(@PathVariable("id") Long id){
		try {
			diagnosticoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}