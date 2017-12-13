package br.com.contaazul.robos.model;

/**
 * Enum que representa os sentidos de um direção
 * 
 * @author gustavo
 *
 */
public enum Sentido {

	NORTH("N"), WEST("W"), SOUTH("S"), EAST("E");

	private String letra;

	public String getLetra() {
		return this.letra;
	}

	private Sentido(String letra) {
		this.letra = letra;
	}

}
