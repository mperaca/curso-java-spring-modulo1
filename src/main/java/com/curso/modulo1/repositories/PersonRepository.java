package com.curso.modulo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modulo1.models.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
	

}
