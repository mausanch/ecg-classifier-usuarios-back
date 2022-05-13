package com.mx.ipn.usuarios.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.MedicosBean;
import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.modelos.entidades.Medico;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;
import com.mx.ipn.usuarios.servicios.MedicoServicio;
import com.mx.ipn.usuarios.servicios.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuariosFacade {

	@Autowired
	private UsuarioServicio usuariosServicio;
	
	@Autowired 
	private MedicoServicio medicoServicio;

	public Usuario guardarUsuario (UsuariosBean usuarioBean) {
		log.info("<----Inicio Facade--->");
		Usuario usuario=usuariosServicio.guardarUsuario(usuarioBean);
		log.info("<----Fin Facade--->");
		return usuario;
	}
	
	
	public Medico guardarMedico(MedicosBean medicoBean) {
		log.info("<----Inicio Facade--->");
		Medico medico= new Medico();
		medico= medicoServicio.guardarMedico(medicoBean);
		log.info("<----Fin Facade--->");
		return medico; 
	}
}
