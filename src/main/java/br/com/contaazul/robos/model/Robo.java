package br.com.contaazul.robos.model;

import java.util.Optional;

import br.com.contaazul.robos.exceptions.PosicaoInvalidaException;

/**
 * Classe que representa um Robô enviado a um determinado Terreno
 * @author gustavo
 *
 */
public class Robo {

	private Terreno terreno;
	
	private Optional<Posicao> posicao = Optional.empty();
	
	public String informarPosicaoAtual() {
		return getPosicao().localizar();
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public Optional<Posicao> getOptionalPosicao() {
		return posicao;
	}
	
	public Posicao getPosicao() {
		return getOptionalPosicao().orElseThrow(() -> new PosicaoInvalidaException());
	}

	public void setPosicao(Optional<Posicao> posicao) {
		this.posicao = posicao;
	}

}
