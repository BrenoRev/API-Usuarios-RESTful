package com.devrev.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devrev.apirest.model.Usuario;
import com.devrev.apirest.model.UsuarioDTO;
import com.devrev.apirest.repository.UsuarioRepository;

@RequestMapping("/usuario")
@RestController
@CrossOrigin(origins =  "*")
@EnableCaching
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/{id}" , produces = "application/json")
	public ResponseEntity<UsuarioDTO> getId(@PathVariable(value = "id") Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return new ResponseEntity<UsuarioDTO>(new UsuarioDTO(usuario.get()), HttpStatus.OK);
	}
	
	/* Vamos Supor que o carregamento de usuario seja um processo lento
	 e queremos controler ele com cache par agilizar o processo */
	
	@GetMapping(value = "/", produces = "application/json")
	
	// Limpa o cache conforme necessário pra não estourar memória
	@CacheEvict(value="allusers", allEntries = true)
	// Atualiza o cache quando tiver modificações
	@CachePut("allusers")
	public ResponseEntity<List<UsuarioDTO>> getAll() throws InterruptedException {
		
		List<Usuario> listUsuario= usuarioRepository.findAll();
		List<UsuarioDTO> listarDTO = new ArrayList<>();
		listUsuario.forEach((user) -> {
			listarDTO.add(new UsuarioDTO(user.getId() ,user.getLogin(), user.getNome(), user.getTelefones()));
		});
		return new ResponseEntity<List<UsuarioDTO>>(listarDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		// Amarrando a foreign key do usuario no telefone
		for(int pos = 0; pos < usuario.getTelefones().size(); pos++) {
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		
		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		
		// Se a senha da alterção for diferente da cadastrada no banco de dados ele vai criptografar antes de salvar novamente
		Usuario usuarioAntigo = usuarioRepository.getById(usuario.getId());
		if(!new BCryptPasswordEncoder().matches(usuarioAntigo.getSenha(), usuario.getSenha())) {
			usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		}

		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	
	@DeleteMapping(value = "/{id}" , produces = "application/json")
	public ResponseEntity<String> deletar(@PathVariable(value = "id") Long id) {
		usuarioRepository.deleteById(id);
		return new ResponseEntity<String>("Usuario com o id " +id+" deletado com sucesso", HttpStatus.OK);
	}
}
