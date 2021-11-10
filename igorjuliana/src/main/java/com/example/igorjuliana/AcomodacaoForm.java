package com.example.igorjuliana;

import java.util.List;

public class AcomodacaoForm {
	
	private TipoAcomodacao tipo;
	private int capacidade;
	private List<Comentario> avaliacoes;
	private String localizacao;
	private boolean permiteAnimais;
	private boolean temEstacionamento;
	
	public Acomodacao atualizar(Acomodacao a) {
		a.setTipo(tipo);
		a.setAvaliacoes(avaliacoes);
		a.setCapacidade(capacidade);
		a.setPermissaoAnimais(permiteAnimais);
		a.setTemEstacionamento(temEstacionamento);
		a.setLocalizacao(localizacao);
		return a;
	}
	
	
	
	
}
