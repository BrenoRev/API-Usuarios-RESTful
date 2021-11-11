package com.devrev.apirest.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String userLogin;
	private String userNome;
	private String userCpf;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private LocalDate userDataNascimento;
	
	private Profissao profissao;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.userLogin = usuario.getLogin();
		this.userNome = usuario.getNome();
		this.userCpf = usuario.getCpf();
		this.userDataNascimento = usuario.getDataNascimento();
		this.profissao = usuario.getProfissao();
	}
	
	// Padrão DTO para imprimir todos
	
	public UsuarioDTO(Long id,String login, String nome, String cpf, LocalDate dataNascimento, Profissao profissao) {
		this.id = id;
		this.userLogin = login;
		this.userNome = nome;
		this.userCpf = cpf;
		this.userDataNascimento = dataNascimento;
		this.profissao = profissao;
	}
	
	
	
	public LocalDate getUserDataNascimento() {
		return userDataNascimento;
	}

	public void setUserDataNascimento(LocalDate userDataNascimento) {
		this.userDataNascimento = userDataNascimento;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
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
