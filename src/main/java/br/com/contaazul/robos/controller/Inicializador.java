package br.com.contaazul.robos.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe responsável pela configuração da inicialização do SpringBoot
 * 
 */
@SpringBootApplication
public class Inicializador {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Inicializador.class, args);
	}
}
