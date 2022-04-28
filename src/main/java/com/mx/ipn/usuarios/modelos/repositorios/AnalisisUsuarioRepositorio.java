package com.mx.ipn.usuarios.modelos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ipn.usuarios.modelos.entidades.AnalisisUsuario;

public interface AnalisisUsuarioRepositorio extends JpaRepository<AnalisisUsuario,String>, AnalisisUsuarioRepositorioCustom {

	
}
