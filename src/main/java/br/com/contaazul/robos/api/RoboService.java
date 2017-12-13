package br.com.contaazul.robos.api;

import br.com.contaazul.robos.model.Robo;

/**
 * Interface de acesso as funcionalidades do Robô
 * 
 * @author gustavo
 *
 */
public interface RoboService {

	/**
	 * Método que permite o envio de comandos a um Robô
	 * 
	 * @param comandos
	 *            Sequência de comandos ao Robô
	 * @param robo
	 *            Robô a ser controlado
	 */
	void enviarComandosAoRobo(String comandos, Robo robo);

	/**
	 * Método para receber a informação da posição atual do Robô
	 * 
	 * @param robo
	 *            Robô ao qual está buscando a informação
	 * @return a posição atual do Robô no formato (x, y, O), onde o 'x' e o 'y'
	 *         identificam as coordenadas do Robô e o 'O' identifica a sua
	 *         orientação atual
	 */
	String receberPosicaoAtual(Robo robo);

}
