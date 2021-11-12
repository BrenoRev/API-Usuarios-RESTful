package com.devrev.apirest.controller;

import java.util.Calendar;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devrev.apirest.model.Usuario;
import com.devrev.apirest.repository.UsuarioRepository;
import com.devrev.apirest.service.EnviaEmailService;
import com.devrev.exceptions.ErrorDetails;

@RestController
@RequestMapping(value = "/recuperar")
public class RecuperacaoController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnviaEmailService emailSend;
	
	@ResponseBody
	@PostMapping(value ="/")
	public ResponseEntity<ErrorDetails> recuperar(@RequestBody Usuario person) throws MessagingException{
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		Usuario user = usuarioRepository.findUserByEmail(person.getEmail());
		
		if(user == null) {
			errorDetails.setCode("404");
			errorDetails.setError("Usuario não encontrado");
		}else {
			
			Random gerador = new Random();
			
			String senhaNova = Integer.toString(gerador.nextInt(88888));
			String salvar = new BCryptPasswordEncoder().encode(senhaNova);
			
			// Rotina de envio de e-mail
			emailSend.enviarEmail("Recuperação de Senha", person.getEmail(), "Sua nova senha é : "+ senhaNova);
			
			usuarioRepository.updateSenha(salvar, person.getEmail());
			
			errorDetails.setCode("200");
			errorDetails.setError("Acesso enviado para o seu e-mail");
		}
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.OK);
	}
}
