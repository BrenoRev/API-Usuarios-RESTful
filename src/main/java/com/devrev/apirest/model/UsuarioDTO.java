package com.devrev.apirest.model;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String userLogin;
	private String userNome;
	private String userCpf;
	
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.userLogin = usuario.getLogin();
		this.userNome = usuario.getNome();
		this.userCpf = usuario.getCpf();
	}
	
	// Padrão DTO para imprimir todos
	
	public UsuarioDTO(Long id,String login, String nome, String cpf) {
		this.id = id;
		this.userLogin = login;
		this.userNome = nome;
		this.userCpf = cpf;
	}
	
	
	public String getUserCpf() {
		return userCpf;
	}

	public void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
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
	
	

}
