package com.mx.ipn.usuarios.servicios.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ipn.usuarios.dominio.bean.InicioSesionUsuarioBean;
import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.dominio.vo.DatosPersonalesVo;
import com.mx.ipn.usuarios.dominio.vo.DatosPersonalesQuery;
import com.mx.ipn.usuarios.dominio.vo.RespuestaInicioUsuarioVo;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;
import com.mx.ipn.usuarios.modelos.repositorios.UsuarioRepositorio;
import com.mx.ipn.usuarios.servicios.UsuarioServicio;
import com.mx.ipn.usuarios.utiles.FormatoFechas;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@PersistenceContext
	EntityManager entityManager;
	
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
	public DatosPersonalesQuery recuperarEdadySexoByID(Long idUsuario) {
		
		List<DatosPersonalesQuery> listUsuario= usuarioRepositorio.findFechaNacimientoAndSexoByIdPersona(idUsuario);
		
		DatosPersonalesQuery edadSexoInterfaceQuery;

		edadSexoInterfaceQuery=listUsuario.get(0);

		if (listUsuario.isEmpty())
			return null;
		log.info (listUsuario.toString());
		
		return edadSexoInterfaceQuery;

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

	@Override
	public DatosPersonalesVo recuperarDatosPersonales(Long idUsuario) {
		Optional<Usuario> optionalUsuario= usuarioRepositorio.findById(idUsuario);
		
		if (optionalUsuario.isEmpty())
			return null;
		log.info (optionalUsuario.toString());
		
		Usuario Usuario = optionalUsuario.get();
		
		DatosPersonalesVo datosPersonalesVo=new DatosPersonalesVo();
		datosPersonalesVo.setNombre(Usuario.getNombres());
		datosPersonalesVo.setApellidoMaterno(Usuario.getApellidoPaterno());
		datosPersonalesVo.setApellidoPaterno(Usuario.getApellidoPaterno());
		datosPersonalesVo.setEdad(FormatoFechas.calcularEdad(Usuario.getFechaNacimiento()));
		datosPersonalesVo.setSexo(Usuario.getSexo());
		
		return datosPersonalesVo;
	}

	@Override
	public Usuario obtenerReferenciaUsuario(Long idUsuario) {
		log.info("<----Inicio servicio Obtener referencia");
		Usuario usuario = entityManager.find(Usuario.class, idUsuario);
		log.info("<----Fin servicio Obtener referencia");
		return usuario;
	}

}
