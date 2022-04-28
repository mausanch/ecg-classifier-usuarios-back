package com.mx.ipn.usuarios.modelos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ipn.usuarios.modelos.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,String>, UsuarioRepositorioCustom {

}
