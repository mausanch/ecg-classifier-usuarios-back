package com.mx.ipn.usuarios.modelos.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "medicos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Medico extends Persona {

	private static final long serialVersionUID = 1L;

	public Medico(Long idPersona, String nombres, String apellidoPaterno, String apellidoMaterno,
			String correoElectronico, LocalDate fechaNacimiento, Integer sexo, String contrasena) {
		super(idPersona, nombres, apellidoPaterno, apellidoMaterno, correoElectronico, fechaNacimiento, sexo, contrasena);
	}

	@Column(name="cedula",length= 10)
	private String Cedula;
	
}
