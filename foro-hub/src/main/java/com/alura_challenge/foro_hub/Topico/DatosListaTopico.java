package com.alura_challenge.foro_hub.Topico;

import java.time.LocalDateTime;

public record DatosListaTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String autor, String curso, StatusTopico status) {
	public DatosListaTopico(Topico topico) {
		this(topico.getId(), topico.getTítulo(), topico.getMensaje(), topico.getFechaCreación(), topico.getAutor().getNombre(), topico.getCurso().getNombre(), topico.getStatus());
	}

}
