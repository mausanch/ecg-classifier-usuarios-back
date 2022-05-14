package com.mx.ipn.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.mx.ipn.usuarios.controladores.UsuarioControlador;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication (scanBasePackages={
"com.mx.ipn.usuarios.controladores"})
@OpenAPIDefinition(info = @Info(title = "Usuarios API", version = "1.0", description = "Gestión de Usuarios"))
public class UsuariosApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

}
