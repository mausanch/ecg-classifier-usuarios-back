package com.mx.ipn.usuarios.servicios;

import com.mx.ipn.usuarios.dominio.bean.MedicosBean;
import com.mx.ipn.usuarios.modelos.entidades.Medico;

public interface MedicoServicio {

	public Medico guardarMedico (MedicosBean medicoBean);
	
	public Medico obtenerInformacionMedico(String idMedico);
	
	public Medico actualizarMedico (MedicosBean medicoBean); 
	
	
}
