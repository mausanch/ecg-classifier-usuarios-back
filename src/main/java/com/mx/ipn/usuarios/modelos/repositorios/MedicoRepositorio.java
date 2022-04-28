package com.mx.ipn.usuarios.modelos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ipn.usuarios.modelos.entidades.Medico;

public interface MedicoRepositorio extends JpaRepository<Medico, String>, MedicoRepositorioCustom{

}
