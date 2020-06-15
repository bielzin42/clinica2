package com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.clinica.model.Ficha;

@Repository
public interface FichaR  extends JpaRepository<Ficha, Long>{

}
