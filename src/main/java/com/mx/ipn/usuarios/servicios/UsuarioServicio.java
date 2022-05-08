package com.mx.ipn.usuarios.servicios;

import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;

public interface UsuarioServicio {
	
	public Usuario guardarUsuario(UsuariosBean usuario);

	public Usuario obtenerInformacionInicioUsuario (String idUsuario);
	
	public Usuario actualizarUsuario (UsuariosBean usuario);
	
}
