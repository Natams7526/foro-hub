package com.alura_challenge.foro_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura_challenge.foro_hub.Topico.DatosActualizarTopico;
import com.alura_challenge.foro_hub.Topico.DatosDetalleTopico;
import com.alura_challenge.foro_hub.Topico.DatosRegistroTopico;
import com.alura_challenge.foro_hub.Topico.TopicoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrar(
            @RequestBody @Valid DatosRegistroTopico datos,
            UriComponentsBuilder uriBuilder) {

        var topico = topicoService.crearTopico(datos);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }
    
    @PutMapping
    public ResponseEntity<DatosDetalleTopico> actualizar(@RequestBody @Valid DatosActualizarTopico datos) {
        var actualizado = topicoService.actualizar(datos);
        return ResponseEntity.ok(new DatosDetalleTopico(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    	topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallar(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.detallar(id));
    }
}
