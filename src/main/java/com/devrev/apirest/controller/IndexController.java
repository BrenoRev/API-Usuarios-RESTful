package com.devrev.apirest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devrev.apirest.model.Usuario;
import com.devrev.apirest.repository.UsuarioRepository;

@RequestMapping("/usuario")
@RestController
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/{id}" , produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		
	}
	
	
}
