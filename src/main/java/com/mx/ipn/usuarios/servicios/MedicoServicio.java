package com.mx.ipn.usuarios.servicios;

import com.mx.ipn.usuarios.dominio.bean.MedicoBean;
import com.mx.ipn.usuarios.modelos.entidades.Medico;

public interface MedicoServicio {

	public Medico guardarMedico (MedicoBean medicoBean);
	
	public Medico obtenerInformacionMedico(String idMedico);
	
	public Medico actualizarMedico (MedicoBean medicoBean); 
	
	
}
