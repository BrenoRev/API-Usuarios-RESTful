package com.devrev.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devrev.apirest.model.Usuario;
import com.devrev.apirest.repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Consultar no banco o usuario
		
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não foi encontrado");
		}
		
		return new User(usuario.getLogin(), usuario.getPassword(), usuario.getAuthorities());
	}

	
	public void atualizaToken(String token, String login) {
		usuarioRepository.atualizaTokenUser(token, login);
	}


	public void insereAcessoPadrao(Long id) {
		// Tirar a constraint que não deixa registrar 2 usuários na mesma tabela
		String constraint = usuarioRepository.consultaConstraintRole();
		// Executar sql puro no java
		if(constraint != null) {
		jdbcTemplate.execute("alter table usuarios_role DROP CONSTRAINT IF EXISTS " + constraint);
		}
		usuarioRepository.insereAcessoRolePadrao(id);
	}
	
}
