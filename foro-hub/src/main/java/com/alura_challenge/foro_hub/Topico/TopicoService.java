package com.alura_challenge.foro_hub.Topico;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alura_challenge.foro_hub.Usuario.CursoRepository;
import com.alura_challenge.foro_hub.Usuario.UsuarioRepository;

import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TopicoService {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Transactional
	public Topico crearTopico(DatosRegistroTopico datos) {
		if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
	        throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
	    }
		var autor = usuarioRepository.getReferenceById(datos.autorId());
		var curso = cursoRepository.getReferenceById(datos.cursoId());
		var topico = new Topico();

		topico.setTitulo(datos.titulo());
		topico.setMensaje(datos.mensaje());
		topico.setAutor(autor);
		topico.setCurso(curso);
		topico.setStatus(StatusTopico.NO_RESPONDIDO);
		topico.setFechaCreación(LocalDateTime.now());

		return topicoRepository.save(topico);
	}

	@Transactional
	public Page<DatosListaTopico> listar(Pageable pageable) {
		return topicoRepository.findAll(pageable).map(DatosListaTopico::new);
	}

	@Transactional
	public Topico actualizar(DatosActualizarTopico datos) {
		var topico = topicoRepository.findById(datos.id())
		        .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado con ID: " + datos.id()));
		topico.actualizar(datos);
		return topico;
	}

	@Transactional
	public void eliminar(Long id) {
		var topico = topicoRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado con ID: " + id));
		topico.marcarComoEliminado();
	}

	@Transactional(readOnly = true)
	public DatosDetalleTopico detallar(Long id) {
	    var topico = topicoRepository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado"));

	    return new DatosDetalleTopico(topico);
	}
}
