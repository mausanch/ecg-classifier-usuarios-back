package com.mx.ipn.usuarios.dominio.vo;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RespuestaInicioUsuarioVo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String Nombre;
	private Long idUsuario;
	private Integer Edad;
	private Integer Sexo;
}
