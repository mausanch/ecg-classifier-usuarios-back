package com.mx.ipn.usuarios.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.mapeadores.UsuariosMapeador;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;
import com.mx.ipn.usuarios.modelos.repositorios.UsuarioRepositorio;
import com.mx.ipn.usuarios.servicios.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired(required = false)
	private UsuariosMapeador usuariosMapeador;

	@Override
	public Usuario guardarUsuario(UsuariosBean usuarioBean) {
		
		Usuario usuario = usuariosMapeador.UsuarioEntityToUsuarioBean(usuarioBean);
		usuario=usuarioRepositorio.save(usuario);
		
		return usuario;
	}

	@Override
	public Usuario obtenerInformacionGeneral(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
