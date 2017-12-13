package br.com.contaazul.robos.model;

/**
 * Classe que representa a posição de um Robô, identificando suas coordenadas e
 * orientação
 * 
 * @author gustavo
 *
 */
public class Posicao {

	private Coordenada coordenada;

	private Orientacao orientacao;

	/**
	 * Método responsável por informar a posição do Robô
	 * 
	 * @return as coordenadas x, y e a orientação do Robô.
	 */
	public String localizar() {
		return "(" + coordenada + ", " + orientacao.getSentido().getLetra() + ")";
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Orientacao getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((orientacao == null) ? 0 : orientacao.hashCode());
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
		Posicao other = (Posicao) obj;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (orientacao == null) {
			if (other.orientacao != null)
				return false;
		} else if (!orientacao.equals(other.orientacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Posicao [coordenada=" + coordenada + ", orientacao=" + orientacao + "]";
	}

}
