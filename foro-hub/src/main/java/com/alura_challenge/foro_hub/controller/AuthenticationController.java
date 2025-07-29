package com.alura_challenge.foro_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura_challenge.foro_hub.Usuario.DatosAutenticacion;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping
	public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos) {
		
		var token = new UsernamePasswordAuthenticationToken(datos.nombre(), datos.contrasena());
		var autenticacion = manager.authenticate(token);
		
		return ResponseEntity.ok().build();
	}

}
