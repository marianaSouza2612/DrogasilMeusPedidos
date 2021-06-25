package Staps;

import java.io.IOException;

import Elementos.Elementos;
import Pages.Metodos;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Tests {

	Metodos mt = new Metodos();
	Elementos el = new Elementos();

	@Dado("que eu esteja no {string}")
	public void que_eu_esteja_no(String Site) throws IOException, InterruptedException {
		mt.abrirCHROME(Site, "");
		mt.pausa(4000, "Pausa para carregar a pagina");

	}

	@Quando("eu realizar o teste para ser feito")
	public void eu_realizar_o_teste_para_ser_feito() throws IOException, InterruptedException {
		mt.clicar(el.getMeuPedidos(), "");
		mt.clicar(el.getFacaLogin(), "");
		mt.submit(el.getFacaLogin(), "");
		mt.escrever(el.getEmCpf(), "fernanda@souza.com.br", "");
		mt.escrever(el.getSenha(), "luc1234", "");
		mt.submit(el.getBtnFacaLogin(), "");
		mt.clicar(el.getAcessoMeusPedidos(), "");
		

	}

	@Entao("eu valido o teste")
	public void eu_valido_o_teste() throws IOException, InterruptedException {
		mt.pausa(45000, "Pausa para fechar");
		mt.fecharNavegador("");

	}

}
