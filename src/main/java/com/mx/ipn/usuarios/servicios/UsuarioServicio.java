package com.mx.ipn.usuarios.servicios;

import com.mx.ipn.usuarios.dominio.bean.InicioSesionUsuarioBean;
import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.dominio.vo.DatosPersonalesVo;
import com.mx.ipn.usuarios.dominio.vo.RespuestaInicioUsuarioVo;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;

public interface UsuarioServicio {
	
	public Usuario guardarUsuario(UsuariosBean usuario);
	
	public Usuario actualizarUsuario (UsuariosBean usuario, Long idUsuario);

	public Usuario obtenerInformacionInicioUsuario (Long idUsuario);	
	
	public DatosPersonalesVo recuperarDatosPersonalesUsuario(Long idUsuario);
	
	public RespuestaInicioUsuarioVo InicioSesionUsuario (InicioSesionUsuarioBean inicioSesionUsuarioBean);
}
