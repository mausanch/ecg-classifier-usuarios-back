package com.mx.ipn.usuarios.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.InicioSesionUsuarioBean;
import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.dominio.vo.DatosPersonalesQuery;
import com.mx.ipn.usuarios.dominio.vo.RespuestaInicioUsuarioVo;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;
import com.mx.ipn.usuarios.modelos.repositorios.UsuarioRepositorio;
import com.mx.ipn.usuarios.servicios.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public Usuario guardarUsuario(UsuariosBean usuarioBean) {
		
		
		Usuario usuario = new Usuario ();
		
		usuario.setNombres(usuarioBean.getNombre());
		usuario.setApellidoPaterno(usuarioBean.getApellidoPaterno());
		usuario.setApellidoMaterno(usuarioBean.getApellidoMaterno());
		usuario.setFechaNacimiento(usuarioBean.getFechaNacimiento());
		usuario.setSexo(usuarioBean.getSexo());
		usuario.setCorreoElectronico(usuarioBean.getCorreoElectronico());
		usuario.setContrasena(usuarioBean.getContrasena());
		
		usuario=usuarioRepositorio.save(usuario);
		
		return usuario;
	}

	@Override
	public Usuario obtenerInformacionInicioUsuario(Long idUsuario) {
		
		Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(idUsuario);
		
		if (optionalUsuario.isPresent())
			idUsuario=null;
		
		return optionalUsuario.get();
	}
	
	@Override
	public DatosPersonalesQuery recuperarDatosPersonalesUsuario(Long idUsuario) {
		
		List<Usuario> listUsuario= usuarioRepositorio.findFechaNacimientoAndSexoByIdPersona(idUsuario);
		
		if (listUsuario.isEmpty())
			return null;
		log.info (listUsuario.toString());
		
		DatosPersonalesQuery datosPersonalesQuery=new DatosPersonalesQuery();
		datosPersonalesQuery.setFechaNacimiento(listUsuario.get(0).getFechaNacimiento());
		datosPersonalesQuery.setSexo(listUsuario.get(0).getSexo());
		
		return datosPersonalesQuery;

	}

	
	@Override
	public Usuario actualizarUsuario(UsuariosBean usuarioBean, Long idUsuario) {

		Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(idUsuario);
		
		if (optionalUsuario.isPresent())
			idUsuario=null;
				
        Usuario usuario = null;

        usuario = (optionalUsuario.isPresent()) ? optionalUsuario.get()
        : new Usuario();
	
		usuario.setNombres(usuarioBean.getNombre());
		usuario.setApellidoPaterno(usuarioBean.getApellidoPaterno());
		usuario.setApellidoMaterno(usuarioBean.getApellidoMaterno());
		usuario.setFechaNacimiento(usuarioBean.getFechaNacimiento());
		usuario.setSexo(usuarioBean.getSexo());
		usuario.setCorreoElectronico(usuarioBean.getCorreoElectronico());
		usuario.setContrasena(usuarioBean.getContrasena());
		
		usuario=usuarioRepositorio.save(usuario);
		
		return usuario;
	}

	@Override
	public RespuestaInicioUsuarioVo InicioSesionUsuario(InicioSesionUsuarioBean inicioSesionUsuarioBean) {
		
		RespuestaInicioUsuarioVo respuestaInicioUsuarioVo = null;
		
		List<Usuario> listUsuario = usuarioRepositorio.findByCorreoElectronicoAndContrasena(inicioSesionUsuarioBean.getCorreoElectronico(),inicioSesionUsuarioBean.getContrasena());
		
		if (listUsuario.isEmpty())
			return respuestaInicioUsuarioVo;
		
		respuestaInicioUsuarioVo = new RespuestaInicioUsuarioVo();
		respuestaInicioUsuarioVo.setNombre(listUsuario.get(0).getNombres());
		respuestaInicioUsuarioVo.setIdUsuario(listUsuario.get(0).getIdPersona());
		respuestaInicioUsuarioVo.setFechaNacimiento(listUsuario.get(0).getFechaNacimiento());
		respuestaInicioUsuarioVo.setSexo(listUsuario.get(0).getSexo());

		return respuestaInicioUsuarioVo;
	}

}
