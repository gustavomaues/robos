package br.com.contaazul.robos.model;

/**
 * Classe que representa um terreno
 * 
 * @author gustavo
 *
 */
public class Terreno {

	private int ladoX;

	private int ladoY;

	public Terreno(int ladoX, int ladoY) {
		super();
		this.ladoX = ladoX;
		this.ladoY = ladoY;
	}

	public int getLadoX() {
		return ladoX;
	}

	public int getLadoY() {
		return ladoY;
	}

}
