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

import com.clinica.clinica.model.Medico;
import com.clinica.clinica.repository.MedicoR;

@RestController
@RequestMapping("/medico")
@CrossOrigin("*")
public class MedicoC {

	@Autowired
	private MedicoR repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> GetByID(@PathVariable String id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Medico>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Medico> Post(@RequestBody Medico medico){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));
		}
	
	@PutMapping
	public ResponseEntity<Medico> Put(@RequestBody Medico medico){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
}
