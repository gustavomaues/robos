package br.com.contaazul.robos.model;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;

/**
 * Classe que representa uma orientação no sentido Sul em uma direção
 * vertical
 * 
 * @author gustavo
 *
 */
public class OrientacaoSul extends Orientacao {

	public OrientacaoSul() {
		super(Sentido.SOUTH);
	}
	
	/**
	 * Método que retorna uma nova orientação a partir de determinado comando,
	 * considerando o Robô atualmente na posição Sul
	 */
	@Override
	public Orientacao getOrientacaoAposComando(Comando comando) throws ComandoInvalidoException {
		try {
			switch (comando) {
			case L:
				return new OrientacaoLeste();
			case R:
				return new OrientacaoOeste();
			case M:
				return this;
			}
			throw new ComandoInvalidoException();
		} catch (NullPointerException e) {
			throw new ComandoInvalidoException();
		}
		
	}

	
}
