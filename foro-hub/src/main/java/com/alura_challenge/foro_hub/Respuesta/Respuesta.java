package com.alura_challenge.foro_hub.Respuesta;

import java.time.LocalDateTime;

import com.alura_challenge.foro_hub.Topico.Topico;
import com.alura_challenge.foro_hub.Usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String mensaje;

	    private LocalDateTime fechaCreacion = LocalDateTime.now();

	    private Boolean solucion = false;

	    @ManyToOne
	    private Topico topico;

	    @ManyToOne
	    private Usuario autor;

}
