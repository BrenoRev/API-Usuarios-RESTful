package com.devrev.apirest.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String login;
	
	private String nome;
	
	private String senha;
	
	@OneToMany(mappedBy="usuario", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	@OneToMany(fetch = FetchType.EAGER)
	// Criar uma tabela no banco de dados com o id do usuario e o id da role que ele tem
	@JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(
	columnNames = {"usuario_id", "role_id"}, name="unique_role_user"), 
	joinColumns = @JoinColumn(name = "usuario_id" , referencedColumnName = "id" , table="usuario", unique = false,
	foreignKey = @ForeignKey (name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
	inverseJoinColumns = @JoinColumn (name = "role_id", referencedColumnName = "id",
	table = "role", unique = false, updatable = false,
	foreignKey = @ForeignKey (name="role_fk" , value = ConstraintMode.CONSTRAINT)))
	private List<Role> roles; /* Os Acessos */ 

	/* Autorizações, os acessos do usuário ROLE_ADMIN ou ROLE_VISITANTE e etc.*/ 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", nome=" + nome + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
