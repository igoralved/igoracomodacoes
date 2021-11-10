package com.example.igorjuliana;

import java.util.ArrayList;
import java.util.List;

public class ComentarioDTO {

	private Long id;
		private String comentario;
	
	public ComentarioDTO(Comentario c) {
		this.id = c.getId();
		this.comentario = c.getComentario();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getComentario() {
		return this.comentario;
	}
	
	public List<ComentarioDTO> converter(List<Comentario> lista){
		List<ComentarioDTO> listanova = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++) {
			ComentarioDTO dto = new ComentarioDTO(lista.get(i));
			listanova.add(dto);
		}return listanova;
	}
	
}
