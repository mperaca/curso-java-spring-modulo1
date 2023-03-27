package com.curso.modulo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.modulo1.models.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
	

}
