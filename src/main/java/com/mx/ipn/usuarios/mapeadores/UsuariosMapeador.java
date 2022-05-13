package com.mx.ipn.usuarios.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.mx.ipn.usuarios.dominio.bean.MedicosBean;
import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.modelos.entidades.Medico;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;


@Mapper(componentModel = "spring")
public interface UsuariosMapeador {
	
	UsuariosMapeador INSTANCE = Mappers.getMapper(UsuariosMapeador.class );
	
	@Mappings({
	@Mapping(target = "idPersona", ignore = true),
	@Mapping(target = "nombres", source="nombre"),
	@Mapping(target = "fechaCreacion", dateFormat = "dd/MM/yyyy HH:mm:ss", ignore = true),
	@Mapping(target = "fechaModificacion", dateFormat = "dd/MM/yyyy HH:mm:ss", ignore = true),
	@Mapping(target = "AnalisisUsuario", ignore = true),
	})
	public abstract Usuario UsuarioBeanToUsuariosEntity (UsuariosBean UsuarioBean);
			
	@Mappings({
	@Mapping(target = "idPersona", ignore = true),
	@Mapping(target = "nombres", source="nombre"),
	@Mapping(target = "fechaCreacion", dateFormat = "dd/MM/yyyy HH:mm:ss", ignore = true),
	@Mapping(target = "fechaModificacion", dateFormat = "dd/MM/yyyy HH:mm:ss", ignore = true),
	})
	public abstract Medico MedicosBeanToMedicosEntity (MedicosBean medicosBean);

}
