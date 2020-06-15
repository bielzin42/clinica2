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

import com.clinica.clinica.model.Ficha;
import com.clinica.clinica.repository.FichaR;

@RestController
@RequestMapping("/ficha")
@CrossOrigin("*")
public class FichaC {
	
	@Autowired
	private FichaR repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Ficha> GetByID(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Ficha>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Ficha> Post(@RequestBody Ficha medico){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));
		}
	
	@PutMapping
	public ResponseEntity<Ficha> Put(@RequestBody Ficha medico){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
