package com.mx.ipn.usuarios.dominio.bean;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InicioSesionUsuarioBean implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String correoElectronico;
	private String contrasena;
	
}
