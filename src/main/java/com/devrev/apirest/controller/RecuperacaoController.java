package com.devrev.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devrev.apirest.model.Usuario;
import com.devrev.apirest.repository.UsuarioRepository;
import com.devrev.exceptions.ErrorDetails;

@RestController
@RequestMapping(value = "/recuperar")
public class RecuperacaoController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@ResponseBody
	@PostMapping(value ="/")
	public ResponseEntity<ErrorDetails> recuperar(@RequestBody Usuario person){
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		Usuario user = usuarioRepository.findUserByEmail(person.getEmail());
		
		if(user == null) {
			errorDetails.setCode("404");
			errorDetails.setError("Usuario não encontrado");
		}else {
			// Rotina de envio de e-mail
			errorDetails.setCode("200");
			errorDetails.setError("Acesso enviado para o seu e-mail");
		}
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.OK);
	}
}
