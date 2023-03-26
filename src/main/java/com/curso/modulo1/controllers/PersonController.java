package com.curso.modulo1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modulo1.models.PersonModel;
import com.curso.modulo1.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public List<PersonModel> listAll() {
		return service.retornaTodasPessoas();
	}
	
	@GetMapping("/{id}")
	public PersonModel listById(@PathVariable Long id) {
		return service.retornaPessoa(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonModel create(@RequestBody PersonModel person) {
		return service.criaPessoa(person);
	}

	@PutMapping("/{id}")	
	public PersonModel update(@PathVariable Long id, @RequestBody PersonModel person) {
		return service.alteraPessoa(id, person);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.excluiPessoa(id);
	}

}
