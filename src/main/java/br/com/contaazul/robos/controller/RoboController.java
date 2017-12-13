package br.com.contaazul.robos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.contaazul.robos.api.RoboService;
import br.com.contaazul.robos.model.Robo;
import br.com.contaazul.robos.model.Terreno;
import br.com.contaazul.robos.model.builders.RoboBuilder;
import br.com.contaazul.robos.service.RoboImpl;

/**
 * Classe responsável por expor o serviço de entrada de comandos ao Robo via REST
 */
@RestController
public class RoboController {

	/**
	 * Método POST que recebe uma sequência de comandos para movimentação de um Robô
	 * 
	 * @param comandos
	 *            String sequência de comandos permitidos (M, L e R) ao Robô.
	 *            Exemplo: MMMLMRM
	 * @return
	 *         <p>
	 *         a posição final do Robô
	 *         <p>
	 *         ou 400 Bad Request caso haja comando ou movimento inválido
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/rest/mars/{comandos}")
	String enviarComandos(@PathVariable String comandos) {

		Terreno terreno = new Terreno(5, 5);
		Robo robo = new RoboBuilder().noTerreno(terreno).comPosicaoInicialPadrao().get();
		
		RoboService roboService = new RoboImpl();
		roboService.enviarComandosAoRobo(comandos, robo);
		
		return roboService.receberPosicaoAtual(robo);
	}

}
