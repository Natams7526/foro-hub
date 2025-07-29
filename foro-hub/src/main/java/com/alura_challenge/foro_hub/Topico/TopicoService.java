package com.alura_challenge.foro_hub.Topico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alura_challenge.foro_hub.Usuario.CursoRepository;
import com.alura_challenge.foro_hub.Usuario.UsuarioRepository;

import jakarta.transaction.Transactional;

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
		var autor = usuarioRepository.getReferenceById(datos.autorId());
		var curso = cursoRepository.getReferenceById(datos.cursoId());
		var topico = new Topico();

		topico.setTítulo(datos.titulo());
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
		var topico = topicoRepository.getReferenceById(datos.id());
		topico.actualizar(datos);
		return topico;
	}

	@Transactional
	public void eliminar(Long id) {
		var topico = topicoRepository.getReferenceById(id);
		topico.marcarComoEliminado();
	}

	@Transactional
	public DatosDetalleTopico detallar(Long id) {
		var topico = topicoRepository.getReferenceById(id);
		return new DatosDetalleTopico(topico);
	}
}
