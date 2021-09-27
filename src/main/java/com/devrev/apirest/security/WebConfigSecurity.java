package com.devrev.apirest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.devrev.apirest.service.ImplementacaoUserDetailsService;

// Mapeia URL, Endereços, Autoriza ou Bloqueia acessos a URL
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
	
	// Configura as solicitações de acesso pro Http
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Ativando a proteção contra usuário que não estão validados por token
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		
		// Ativando a permissão para acesso a página inicial do sistema ex: sistema.com.br/index.html
		.disable().authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/index").permitAll()
		
		// URL DE Logout - Redireciona após o user deslogar do sistema
		.anyRequest().authenticated().and().logout().logoutSuccessUrl("/index")
		
		// Mapeia a URL de Logout e invalida o usuário
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		// Filtra as requisições de login para autenticação
		
		// Filtra demais requisiçõesp ara verificar a presença do TOKEN JWT no Header Http
		
		}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Service que irá consultar o usuário no banco de dados
		auth.userDetailsService(implementacaoUserDetailsService)
		
		// Padrão de codificação de senha do usuário com BCryptPasswordEncoder
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
