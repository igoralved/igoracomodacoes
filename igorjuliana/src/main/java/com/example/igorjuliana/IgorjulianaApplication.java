package com.example.igorjuliana;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IgorjulianaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgorjulianaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AcomodacaoRepository repositorio, ComentarioRepository comentarios) {
		return (args) ->{
			Comentario c1 = new Comentario("Ambiente Limpo");
			Acomodacao a1 = new Acomodacao(TipoAcomodacao.CASA, 4, "Gramado", true, true);
			a1.addComment(c1);
			comentarios.save(c1);
			repositorio.save(a1);
		};
	}
	

}
