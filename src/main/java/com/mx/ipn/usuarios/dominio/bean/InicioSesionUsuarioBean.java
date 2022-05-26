package com.mx.ipn.usuarios.dominio.bean;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class InicioSesionUsuarioBean implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String correoElectronico;
	private String contrasena;
	
}
