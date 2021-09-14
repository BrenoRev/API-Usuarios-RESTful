package com.devrev.apirest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuario")
@RestController
public class IndexController {

	@GetMapping(value = "/{salario}" , produces = "application/json")
	public ResponseEntity init(@RequestParam(value = "nome", defaultValue="Nome não informado", required = false) String nome,
								@PathVariable(value = "salario") Double salario) {
		System.out.println(nome);
		return new ResponseEntity("Olá REST Spring Boot " + nome+ " Salario é: " + salario, HttpStatus.OK);
	}
	
	
}
