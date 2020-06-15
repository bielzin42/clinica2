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

import com.clinica.clinica.model.Especialidade;
import com.clinica.clinica.repository.EspecialidadeR;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin("*")
public class EspecialidadeC {
	
	@Autowired
	private EspecialidadeR repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidade> GetByID(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Especialidade>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Especialidade> Post(@RequestBody Especialidade especialidade){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));
		}
	
	@PutMapping
	public ResponseEntity<Especialidade> Put(@RequestBody Especialidade especialidade){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}