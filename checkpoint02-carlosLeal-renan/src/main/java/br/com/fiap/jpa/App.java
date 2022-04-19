package br.com.fiap.jpa;

import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Fabricante;
import br.com.fiap.jpa.service.impl.AcessorioServiceImpl;
import br.com.fiap.jpa.service.impl.CarroServiceImpl;
import br.com.fiap.jpa.service.impl.FabricanteServiceImpl;

public class App {

	public static void main(String[] args) {
		
		CarroServiceImpl carroService =  CarroServiceImpl.getInstance();
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		FabricanteServiceImpl fabricanteService = FabricanteServiceImpl.getInstance();
		
		Carro carro1 = new Carro("abc-1234", "laranja", "15121uj121g3ug");
		
		Fabricante seuZe = new Fabricante();
		seuZe.setDescricao("Fabrica bancos de couro");
		
		Acessorio acs1 = new Acessorio();
		acs1.setDescricao("Espelho retrovisor");
		
		Acessorio acs2 = new Acessorio();
		acs2.setDescricao("Manopla de câmbio");
		
		carroService.inserir(carro1);
		fabricanteService.inserir(seuZe);
		acessorioService.inserir(acs1);
		acessorioService.inserir(acs2);
		
		
		carroService.listar().forEach(System.out::println);
	
	}

}
