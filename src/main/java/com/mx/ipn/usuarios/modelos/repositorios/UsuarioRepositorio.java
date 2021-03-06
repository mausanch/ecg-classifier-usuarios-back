package com.mx.ipn.usuarios.modelos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ipn.usuarios.dominio.vo.DatosPersonalesQuery;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>, UsuarioRepositorioCustom {

		public List<DatosPersonalesQuery> findFechaNacimientoAndSexoByIdPersona(Long idUsuario);
		
		public List <Usuario> findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena);
}
