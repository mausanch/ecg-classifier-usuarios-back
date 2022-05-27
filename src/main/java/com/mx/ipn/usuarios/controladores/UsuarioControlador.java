package com.mx.ipn.usuarios.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ipn.usuarios.dominio.bean.InicioSesionUsuarioBean;
import com.mx.ipn.usuarios.dominio.bean.MedicosBean;
import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.dominio.vo.DatosPersonalesVo;
import com.mx.ipn.usuarios.dominio.vo.ListaHistorialVo;
import com.mx.ipn.usuarios.dominio.vo.RespuestaInicioUsuarioVo;
import com.mx.ipn.usuarios.facade.UsuariosFacade;
import com.mx.ipn.usuarios.modelos.entidades.Medico;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;
import com.mx.ipn.usuarios.servicios.MedicoServicio;
import com.mx.ipn.usuarios.servicios.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioControlador {
	
	//@Autowired
	//private UsuariosFacade usuariosFacade;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired	
	private MedicoServicio medicoServicio;
	
	@PostMapping(value="/usuario/guardar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> guardarUsuarios (@Valid @RequestBody UsuariosBean usuariosBean ){
		log.info("<----- Inicio petición ----->");
				
		ResponseEntity<Usuario> resultado = null;
		
		Usuario usuario = usuarioServicio.guardarUsuario(usuariosBean);
		
		resultado = new ResponseEntity <> (usuario, HttpStatus.CREATED);
		
		log.info("---Fin petición controlador Usuario----");
		return resultado;
	}
	
	
	
	@PutMapping(value="/usuario/actualizar/{id_usuario}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> actualizarUsuarios (@Valid @PathVariable ("id_usuario") Long idUsuario,@RequestBody UsuariosBean usuariosBean ){
		log.info("<----- Inicio petición ----->");
		
		ResponseEntity<Usuario> resultado = null;
		
		Usuario usuario = usuarioServicio.actualizarUsuario(usuariosBean, idUsuario);
		
		resultado = new ResponseEntity <> (usuario, HttpStatus.CREATED);
		
		log.info("---Fin petición controlador Usuario----");
		return resultado;
	}
	
	@GetMapping("/usuario/inicio/{id_usuario}")
	public ResponseEntity <RespuestaInicioUsuarioVo> inicioUsuarios (@PathVariable("id_usuario") String idUsuario){
		
		ResponseEntity <RespuestaInicioUsuarioVo> resultado=null;
		
		RespuestaInicioUsuarioVo RespuestaInicioVo = null;
		
		resultado = new ResponseEntity <> (RespuestaInicioVo, HttpStatus.OK);
		
		return resultado;
		
	}

	@GetMapping("/historial/{id_usuario}")
	public ResponseEntity <ListaHistorialVo> historialUsuario (@PathVariable("id_usuario") String idUsuario){
		
		ResponseEntity <ListaHistorialVo> resultado=null;
		
		ListaHistorialVo RespuestaInicioVo = null;
		
		resultado = new ResponseEntity <> (RespuestaInicioVo, HttpStatus.OK);
		
		return resultado;
	}
	@CrossOrigin	
	@GetMapping("/usuario/datos/{id_usuario}")
	public ResponseEntity <DatosPersonalesVo> obtenerEdadSexoUsuario (@PathVariable("id_usuario") Long idUsuario){
		log.info("<----- Inicio petición ----->");

		ResponseEntity <DatosPersonalesVo> resultado=null;
		
		DatosPersonalesVo datosPersonalesVo = usuarioServicio.recuperarDatosPersonalesUsuario(idUsuario);
		
		resultado = new ResponseEntity <> (datosPersonalesVo, HttpStatus.OK);
		log.info("<----- Inicio petición ----->");		
		return resultado;
	}
	
	@CrossOrigin(origins="http://localhost:4200/**")
	@PostMapping("/usuario/inicio-sesion")
	public ResponseEntity <RespuestaInicioUsuarioVo> inicioSesion (@RequestBody InicioSesionUsuarioBean inicioSesionUsuarioBean){
		log.info("<----- Inicio petición ----->");

		ResponseEntity <RespuestaInicioUsuarioVo> resultado=null;
		
		RespuestaInicioUsuarioVo  respuestaInicioUsuarioVo = null;
		
		respuestaInicioUsuarioVo = usuarioServicio.InicioSesionUsuario(inicioSesionUsuarioBean);
		
		if (respuestaInicioUsuarioVo==null){
			resultado = new ResponseEntity <> (respuestaInicioUsuarioVo, HttpStatus.UNAUTHORIZED);
		}else {
			resultado = new ResponseEntity <> (respuestaInicioUsuarioVo, HttpStatus.OK);
		}
		
		log.info("<----- Fin petición ----->");		
		return resultado;
	}

	
	@GetMapping("/recuperarDatosAnalisis/{id_usuario}")
	public ResponseEntity <RespuestaInicioUsuarioVo> recuperarDatosAnalisis (@PathVariable("id_usuario") String idUsuario){
		
		ResponseEntity <RespuestaInicioUsuarioVo> resultado=null;
		
		RespuestaInicioUsuarioVo RespuestaInicioVo = null;
		
		resultado = new ResponseEntity <> (RespuestaInicioVo, HttpStatus.OK);
		
		return resultado;
		
	}
	
	@PostMapping(value="/medico/guardarMedico")
	public ResponseEntity<Medico> guardarMedicos (@Valid @RequestBody MedicosBean medicosBean ){
		log.info("<----- Inicio petición ----->");
		ResponseEntity <Medico> resultado=null;
		Medico medicos=medicoServicio.guardarMedico(medicosBean);
		
		resultado = new ResponseEntity <> (medicos, HttpStatus.OK);
		log.info("<----- Fin petición ----->");
		return resultado;
	}
	
	@PutMapping(value="/medico/actualizar/{id_medico}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Medico> actualizarMedico (@PathVariable ("id_medico") Long idMedico,@Valid @RequestBody MedicosBean medicoBean ){
		log.info("<----- Inicio petición ----->");
		
		ResponseEntity<Medico> resultado = null;
		
		Medico medico = medicoServicio.actualizarMedico(medicoBean, idMedico);
		
		resultado = new ResponseEntity <> (medico, HttpStatus.CREATED);
		
		log.info("---Fin petición controlador Usuario----");
		return resultado;
	}
	
}
