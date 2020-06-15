package com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.clinica.model.Especialidade;

@Repository
public interface EspecialidadeR extends JpaRepository<Especialidade, Long>{
	
}
