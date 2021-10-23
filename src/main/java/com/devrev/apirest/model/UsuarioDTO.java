package com.devrev.apirest.model;

import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String userLogin;
	private String userNome;
	private List<Telefone> userTelefones;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.userLogin = usuario.getLogin();
		this.userNome = usuario.getNome();
		this.userTelefones = usuario.getTelefones();
	}
	
	// Padrão DTO para imprimir todos
	
	public UsuarioDTO(Long id,String login, String nome, List<Telefone> telefones) {
		this.id = id;
		this.userLogin = login;
		this.userNome = nome;
		this.userTelefones = telefones;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserNome() {
		return userNome;
	}
	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}
	public List<Telefone> getUserTelefones() {
		return userTelefones;
	}
	public void setUserTelefones(List<Telefone> userTelefones) {
		this.userTelefones = userTelefones;
	}
	
	

}
