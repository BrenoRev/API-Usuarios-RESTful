package com.devrev.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //  implements WebMvcConfigurer
public class ApiRestApplication{

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	/* Mapeamento Global 
	// Libera os end-points do usuario para POST PUT GET e DELETE para todos
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/usuario/**")
		.allowedMethods("POST", "PUT", "GET", "DELETE")
		.allowedOrigins("*");
	}
	*/
}
