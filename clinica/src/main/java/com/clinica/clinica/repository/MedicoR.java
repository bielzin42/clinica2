package com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.clinica.model.Medico;

@Repository
public interface MedicoR extends JpaRepository<Medico, String>{

}
