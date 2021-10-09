package com.devrev.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1, initialValue = 1)
public class Role  implements GrantedAuthority{
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	@Id
	private Long id;
	
	private String nomeRole; /* Papel, exemplo ROLE_SECRETÁRIO ou ROLE_GERENTE */

	@Override
	public String getAuthority() { // Retorna o nome do papel, acesso ou autorização ex: ROLE_GERENTE
		return this.nomeRole;
	}
	
	@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonIgnore
	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}


}
