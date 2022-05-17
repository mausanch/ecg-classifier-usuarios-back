package com.mx.ipn.usuarios.dominio.vo;

import java.util.List;

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
public class RespuestaInicioUsuarioVo {
	private String Nombre;
	private Integer Edad;
	private Integer Sexo;
	
	private List<Object> Historial;
}
