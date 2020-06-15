package com.clinica.clinica.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.clinica.model.Paciente;
import com.clinica.clinica.repository.PacienteR;

@RestController
@RequestMapping("/paciente")
@CrossOrigin("*")
public class PacienteC {

	@Autowired
	private PacienteR repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> GetByID(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Paciente>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Paciente> Post(@RequestBody Paciente paciente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(paciente));
		}
	
	@PutMapping
	public ResponseEntity<Paciente> Put(@RequestBody Paciente paciente){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(paciente));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
