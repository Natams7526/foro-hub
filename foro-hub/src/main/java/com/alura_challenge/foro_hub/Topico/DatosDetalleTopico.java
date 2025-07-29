package com.alura_challenge.foro_hub.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
	Long id,
    String titulo,
    String mensaje,
    String status,
    String autorNombre,
    String cursoNombre,
    LocalDateTime fechaCreacion
) {
    public DatosDetalleTopico(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getStatus().name(),
            topico.getAutor().getNombre(),
            topico.getCurso().getNombre(),
            topico.getFechaCreación()
        );
    }


}
