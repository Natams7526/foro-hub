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
import com.alura_challenge.foro_hub.Usuario.Usuario;
import com.alura_challenge.foro_hub.controller.infra.security.DatosTokenJWT;
import com.alura_challenge.foro_hub.controller.infra.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping
	public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos) {
		
		var authenticationToken = new UsernamePasswordAuthenticationToken(datos.nombre(), datos.contrasena());
		var autenticacion = manager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
	}

}
