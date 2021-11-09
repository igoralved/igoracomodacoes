package com.example.igorjuliana;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

enum TipoAcomodacao{
	CASA,
	APARTAMENTO,
	QUARTO
}

@Entity
public class Acomodacao {

	@Id
	private Long id;
	
	private TipoAcomodacao tipo;
	private int capacidade;
	private List<String> avaliacoesdeoutroshospedes;
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
		this.avaliacoesdeoutroshospedes = new ArrayList<>();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public TipoAcomodacao getTipo() {
		return this.tipo;
	}
	
	public Integer getCapacidade() {
		return this.capacidade;
	}
	
	public List<String> getAvaliacoes(){
		return this.avaliacoesdeoutroshospedes;
	}
	
	public String getLocalizacao() {
		return this.localizacao;
	}
	
	public String getPermiteAnimais() {
		if(permiteAnimais) {
			return "Sim";
		}return "Nao";
	}
	
	public String getTemEstacionamento() {
		if(temEstacionamento) {
			return "Sim";
		}return "Nao";
	}
	
}
