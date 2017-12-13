package br.com.contaazul.robos.model;

import br.com.contaazul.robos.exceptions.ComandoInvalidoException;

/**
 * Classe que representa uma orientação no sentido Norte em uma direção vertical
 * 
 * @author gustavo
 *
 */
public class OrientacaoNorte extends Orientacao {

	public OrientacaoNorte() {
		super(Sentido.NORTH);
	}

	/**
	 * Método que retorna uma nova orientação a partir de determinado comando,
	 * considerando o Robô atualmente na posição Norte
	 */
	@Override
	public Orientacao getOrientacaoAposComando(Comando comando) throws ComandoInvalidoException {
		try {
			switch (comando) {
			case L:
				return new OrientacaoOeste();
			case R:
				return new OrientacaoLeste();
			case M:
				return this;
			default:
				throw new ComandoInvalidoException();
			}
			
		} catch (NullPointerException e) {
			throw new ComandoInvalidoException();
		}
	}
	
}
