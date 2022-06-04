package com.mx.ipn.usuarios.dominio.vo;

import java.time.LocalDate;


public interface DatosPersonalesQuery {

	LocalDate getFechaNacimiento();
	Integer getSexo();
	String getNombres();
	String apellidoMaterno();
	String apellidoPaterno();
}