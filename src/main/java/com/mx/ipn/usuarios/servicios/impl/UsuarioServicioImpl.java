package com.mx.ipn.usuarios.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.dominio.vo.DatosPersonalesVo;
import com.mx.ipn.usuarios.mapeadores.UsuariosMapeador;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;
import com.mx.ipn.usuarios.modelos.repositorios.UsuarioRepositorio;
import com.mx.ipn.usuarios.servicios.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Service
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
	public DatosPersonalesVo recuperarDatosPersonalesUsuario(Long idUsuario) {
		
		List<Usuario> listUsuario= usuarioRepositorio.findFechaNacimientoAndSexoByIdPersona(idUsuario);
		
		if (listUsuario.isEmpty())
			return null;
		
		DatosPersonalesVo datosPersonalesVo=new DatosPersonalesVo();
		datosPersonalesVo.setFechaNacimiento(listUsuario.get(0).getFechaNacimiento());
		datosPersonalesVo.setSexo(listUsuario.get(0).getSexo());
		
		return datosPersonalesVo;

	}

	
	@Override
	public Usuario actualizarUsuario(UsuariosBean usuarioBean, Long idUsuario) {

		Optional<Usuario> opionalUsuario = usuarioRepositorio.findById(idUsuario);
		
		if (opionalUsuario.isPresent())
			idUsuario=null;
				
        Usuario usuario = null;

        usuario = (opionalUsuario.isPresent()) ? opionalUsuario.get()
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

}
