package com.curso.modulo1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modulo1.exceptions.ResourceNotFoundException;
import com.curso.modulo1.models.PersonModel;
import com.curso.modulo1.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public List<PersonModel> retornaTodasPessoas() {
		return personRepository.findAll();		
	}
	
	public PersonModel retornaPessoa(Long id) {				
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!")); 		
	}
	
	public PersonModel criaPessoa(PersonModel person) {		
		return personRepository.save(person);
	}
	
	public PersonModel alteraPessoa(Long id, PersonModel person) {
		
		PersonModel personFind = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		personFind.setFirstName(person.getFirstName());
		personFind.setLastName(person.getLastName());
		personFind.setAddress(person.getAddress());
		personFind.setGender(person.getGender());
		
		return personRepository.save(personFind);	
	}
	
	public void excluiPessoa(Long id) {
		personRepository.deleteById(id);
	}
}
