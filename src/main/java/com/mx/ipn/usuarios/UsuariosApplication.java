package com.mx.ipn.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.mx.ipn.usuarios.controladores.UsuarioControlador;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={
"com.mx.ipn.usuarios", "com.mx.ipn.usuarios.facade"})
@EnableSwagger2
@ComponentScan(basePackageClasses = {
	    UsuarioControlador.class
	})

public class UsuariosApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

}
