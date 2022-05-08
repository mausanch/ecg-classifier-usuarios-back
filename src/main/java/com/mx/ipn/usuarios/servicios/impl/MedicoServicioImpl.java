package com.mx.ipn.usuarios.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.MedicoBean;
import com.mx.ipn.usuarios.mapeadores.UsuariosMapeador;
import com.mx.ipn.usuarios.modelos.entidades.Medico;
import com.mx.ipn.usuarios.modelos.repositorios.MedicoRepositorio;
import com.mx.ipn.usuarios.modelos.repositorios.UsuarioRepositorio;
import com.mx.ipn.usuarios.servicios.MedicoServicio;

@Service
public class MedicoServicioImpl implements MedicoServicio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired(required = false)
	private UsuariosMapeador usuariosMapeador;


	@Override
	public Medico guardarMedico(MedicoBean medicoBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico obtenerInformacionMedico(String idMedico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico actualizarMedico(MedicoBean medicoBean) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
