package com.mx.ipn.usuarios.controladores;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;
import com.mx.ipn.usuarios.dominio.vo.RespuestaInicioUsuarioVo;
import com.mx.ipn.usuarios.facade.UsuariosFacade;
import com.mx.ipn.usuarios.modelos.entidades.Usuario;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
	
	private final static Logger log = LoggerFactory.getLogger(UsuariosBean.class);
	
	//@Autowired
	private UsuariosFacade usuariosFacade;
	
	@PostMapping(value="/guardar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> guardarUsuarios (@Valid @RequestBody RespuestaInicioUsuarioVo usuariosBean1 ){
		ResponseEntity<Usuario> resultado = null;
		
		UsuariosBean usuariosBean = null;
		 
		Usuario usuario = usuariosFacade.guardarUsuario(usuariosBean);
		
		resultado = new ResponseEntity <> (usuario, HttpStatus.CREATED);
		
		log.info("---Fin petición controlador Usuario----");
		return resultado;
	}
	
	@GetMapping("/inicio/{id_usuario}")
	public ResponseEntity <RespuestaInicioUsuarioVo> inicioUsuarios (@PathVariable("id_usuario") String idUsuario){
		
		ResponseEntity <RespuestaInicioUsuarioVo> resultado=null;
		
		RespuestaInicioUsuarioVo RespuestaInicioVo = null;
		
		resultado = new ResponseEntity <> (RespuestaInicioVo, HttpStatus.OK);
		
		return resultado;
		
	}
	
	
}
