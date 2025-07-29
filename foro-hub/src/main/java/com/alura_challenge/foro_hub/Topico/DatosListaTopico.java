package com.alura_challenge.foro_hub.Topico;

public record DatosListaTopico(Long id, String titulo, String autor, String curso, StatusTopico status) {
	 public DatosListaTopico(Topico topico) {
	        this(topico.getId(), topico.getTítulo(), topico.getAutor().getNombre(), topico.getCurso().getNombre(), topico.getStatus());
	    }

}
