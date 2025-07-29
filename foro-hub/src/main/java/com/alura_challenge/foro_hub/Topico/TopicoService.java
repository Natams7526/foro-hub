package com.alura_challenge.foro_hub.Topico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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
}

