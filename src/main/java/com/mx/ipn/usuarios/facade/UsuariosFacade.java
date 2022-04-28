package com.mx.ipn.usuarios.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;
import com.mx.ipn.usuarios.servicios.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuariosFacade {

	@Autowired
	private UsuarioServicio usuariosServicio;
	
	private final static Logger log = LoggerFactory.getLogger(UsuariosBean.class);
	
	public Usuario guardarUsuario (UsuariosBean usuarioBean) {
		log.info("Inicio Facade");
		
		Usuario usuario=usuariosServicio.guardarUsuario(usuarioBean);
		
		
		
		log.info("Fin Facade");
		return usuario;
	}
}
