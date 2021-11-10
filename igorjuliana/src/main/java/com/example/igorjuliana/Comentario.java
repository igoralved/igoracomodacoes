package com.example.igorjuliana;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comentario")
public class Comentario  { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String comentario;
	
	public Comentario() {}
	
	
	public Comentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getComentario() {
		return this.comentario;
	}
	
}
