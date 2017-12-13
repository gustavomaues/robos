package br.com.contaazul.robos.model;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;

/**
 * Classe abastrata que define o sentido em que o Robô deve percorrer em
 * determinada direção
 * 
 * @author gustavo
 *
 */
public abstract class Orientacao {

	private Sentido sentido;

	public Orientacao(Sentido sentido) {
		this.sentido = sentido;
	}

	public Sentido getSentido() {
		return this.sentido;
	}

	public abstract Orientacao getOrientacaoAposComando(Comando comando) throws ComandoInvalidoException;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sentido == null) ? 0 : sentido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orientacao other = (Orientacao) obj;
		if (sentido != other.sentido)
			return false;
		return true;
	}

}
