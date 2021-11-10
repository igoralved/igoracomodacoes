package com.example.igorjuliana;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

enum TipoAcomodacao{
	CASA,
	APARTAMENTO,
	QUARTO
}

@Entity
@Table(name = "Acomodacao")
public class Acomodacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private TipoAcomodacao tipo;
	private int capacidade;
	
	@OneToMany
	@JoinColumn(name = "id_c")
	private List<Comentario> avaliacoes;
	
	
	private String localizacao;
	private boolean permiteAnimais;
	private boolean temEstacionamento;
	
	
	public Acomodacao() {
		
	}
	
	public Acomodacao(TipoAcomodacao tipo, int capacidade, String localizacao, boolean permitea, boolean teme) {
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.localizacao = localizacao;
		this.permiteAnimais = permitea;
		this.temEstacionamento = teme;
		this.avaliacoes = new ArrayList<Comentario>();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public TipoAcomodacao getTipo() {
		return this.tipo;
	}
	
	public void setTipo(TipoAcomodacao tipo) {
		this.tipo = tipo;
	}
	
	public Integer getCapacidade() {
		return this.capacidade;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public List<Comentario> getAvaliacoes(){
		return this.avaliacoes;
	}
	
	public void setAvaliacoes(List<Comentario> nova) {
		this.avaliacoes = nova;
	}
	
	public String getLocalizacao() {
		return this.localizacao;
	}
	
	public void setLocalizacao(String nome) {
		this.localizacao = nome;
	}
	
	public boolean getPermiteAnimais() {
		if(permiteAnimais) {
			return true;
		}return false;
	}
	
	public void setPermissaoAnimais(boolean permissao) {
		this.permiteAnimais = permissao;
	}
	
	public boolean getTemEstacionamento() {
		if(temEstacionamento) {
			return true;
		}return false;
	}
	
	public void setTemEstacionamento(boolean permissao) {
		this.temEstacionamento = permissao;
	}
	
	public void addComment(Comentario comentario) {
		this.avaliacoes.add(comentario);
	}
	
}
