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
public class HistorialVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date fechaAnalisis;
	private Long idAnalisis;
	private String resultado;
}
