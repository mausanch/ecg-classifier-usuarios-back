package com.mx.ipn.usuarios.dominio.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("deprecation")
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RespuestaModificacionUsuarioVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String apellidoPaterno;

	private String apellidoMaterno;
	
	private Date fechaNacimiento;

	private Integer sexo;
	
	private String correoElectronico;

	private String contrasena;
}
