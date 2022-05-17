package com.mx.ipn.usuarios.dominio.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Builder
@ToString
@Slf4j
public class UsuariosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Tolerate
	public UsuariosBean () {
		log.info("Creando UsuariosBean");
	}
	
	@NotEmpty(message = "El Nombre no puede ser nulo" )
	private String nombre;
	
	@NotEmpty(message = "El Apellido Paterno no puede ser nulo" )
	private String apellidoPaterno;

	@NotEmpty(message = "El Apellido Materno no puede ser nulo" )
	private String apellidoMaterno;
	
	@NotEmpty(message = "La fecha de nacimiento no puede ser nula" )
	private Date fechaNacimiento;
	
	@Min(value = 0, message = "El sexo solo puede ser 1 o 0")
    @Max(value = 1, message = "El sexo solo puede ser 1 o 0")
	@NotEmpty(message = "El sexo no puede ser nulo" )
	private Integer sexo;
		
	@NotEmpty(message = "El Correo Electronico no puede ser nulo" )
	@Email(message = "El correo electronico debe ser valido")
	private String correoElectronico;

    @Size(min = 6, message = "La contraseña debe contener al menos 6 caracteres")
	@NotEmpty(message = "La contraseña no puede ser nula" )
	private String contrasena;

}
