package com.devrev.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication  //  implements WebMvcConfigurer
public class ApiRestApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}


	// Libera os end-points do usuario para POST PUT GET e DELETE para todos
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("**")
		.allowedMethods("POST", "PUT", "GET", "DELETE")
		.allowedOrigins("*");
	}
	
}
