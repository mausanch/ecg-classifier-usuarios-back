package com.mx.ipn.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Usuarios API", version = "1.0", description = "Gestión de Usuarios"))
public class UsuariosApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

}
