package com.example.igorjuliana;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AcomodacaoDTO {

	
	private Long id;
		private TipoAcomodacao tipo;
		private int capacidade;
		private List<ComentarioDTO> avaliacoes = new ArrayList<>();
		private String localizacao;
		private boolean permiteAnimais;
		private boolean temEstacionamento;
	
	public AcomodacaoDTO(Acomodacao a) {
		this.id = a.getId();
		this.tipo = a.getTipo();
		this.capacidade = a.getCapacidade();
		this.avaliacoes.addAll(a.getAvaliacoes().stream().map(ComentarioDTO::new).collect(Collectors.toList()));
		this.localizacao = a.getLocalizacao();
		this.permiteAnimais = a.getPermiteAnimais();
		this.temEstacionamento = a.getTemEstacionamento();
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
	
	public List<ComentarioDTO> getAvaliacoes(){
		return this.avaliacoes;
	}
	
	public String getLocalizacao() {
		return this.localizacao;
	}
	
	public boolean getPermiteAnimais() {
		if(permiteAnimais) {
			return true;
		}return false;
	}
	
	public boolean getTemEstacionamento() {
		if(temEstacionamento) {
			return true;
		}return false;
	}
	
	public static List<AcomodacaoDTO> converter(List<Acomodacao> lista){
		List<AcomodacaoDTO> listanova = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++) {
			AcomodacaoDTO dto = new AcomodacaoDTO(lista.get(i));
			listanova.add(dto);
		}return listanova;
	}
	
}
