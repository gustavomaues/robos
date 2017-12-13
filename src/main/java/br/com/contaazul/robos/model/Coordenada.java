package br.com.contaazul.robos.model;

/**
 * Classe responsável por armazenar posições no sistema de coordenadas
 * cartesianas (x, y)
 * 
 * @author gustavo
 *
 */
public class Coordenada {

	private int x;

	private int y;

	public Coordenada(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void avancarX() {
		this.x++;
	}

	public void avancarY() {
		this.y++;
	}

	public void recuarX() {
		this.x--;
	}

	public void recuarY() {
		this.y--;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
