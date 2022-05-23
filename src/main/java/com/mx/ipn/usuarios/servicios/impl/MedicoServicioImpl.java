package com.mx.ipn.usuarios.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.MedicosBean;
import com.mx.ipn.usuarios.mapeadores.UsuariosMapeador;
import com.mx.ipn.usuarios.modelos.entidades.Medico;
import com.mx.ipn.usuarios.modelos.repositorios.MedicoRepositorio;
import com.mx.ipn.usuarios.servicios.MedicoServicio;

@Service
public class MedicoServicioImpl implements MedicoServicio{
	
	@Autowired
	private MedicoRepositorio medicoRepositorio;
	
	//@Autowired
	private UsuariosMapeador usuariosMapeador;


	@Override
	public Medico guardarMedico(MedicosBean medicoBean) {
		Medico medico=null;
		
		medico= usuariosMapeador.MedicosBeanToMedicosEntity(medicoBean);
		medico=medicoRepositorio.save(medico);
		return medico;
	}

	@Override
	public Medico obtenerInformacionMedico(String idMedico) {

		
		return null;
	}

	@Override
	public Medico actualizarMedico(MedicosBean medicoBean, Long idMedico) {
		Medico medico= null;
		medico= usuariosMapeador.MedicosBeanToMedicosEntity(medicoBean);
		medico.setIdPersona(idMedico);
		medico=medicoRepositorio.save(medico);
		return medico;
		
	}

}
