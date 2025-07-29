package com.alura_challenge.foro_hub.Topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.alura_challenge.foro_hub.Curso.Curso;
import com.alura_challenge.foro_hub.Respuesta.Respuesta;
import com.alura_challenge.foro_hub.Usuario.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String mensaje;

	private LocalDateTime fechaCreación = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;

	@ManyToOne
	private Usuario autor;

	@ManyToOne
	private Curso curso;

	@OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
	private List<Respuesta> respuestas = new ArrayList<>();

	public void actualizar(DatosActualizarTopico datos) {
		if (datos.titulo() != null)
			this.titulo = datos.titulo();
		if (datos.mensaje() != null)
			this.mensaje = datos.mensaje();
	}

	public void marcarComoEliminado() {
		this.status = StatusTopico.ELIMINADO;
	}
}
