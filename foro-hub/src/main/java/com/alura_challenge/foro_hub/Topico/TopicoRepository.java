package com.alura_challenge.foro_hub.Topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	boolean existsByTituloAndMensaje(String titulo, String mensaje);

}
