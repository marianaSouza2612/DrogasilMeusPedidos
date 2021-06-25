package Elementos;

import org.openqa.selenium.By;

public class Elementos {

	private By btnLogn = By.xpath("sc-ieebsP dPVgcd search-input__search-button");

	public By getBtnLogn() {
		return btnLogn;
	}

	private By button = By.xpath("//*[@id=\"fixed-container-styles\"]/header/div/form/button[2]");

	public By getButton() {
		return button;
	}

	public By pesquisa = By.id("searchHeader");

	private By lupa = By.cssSelector("svg-inline--fa fa-search fa-w-16 ");

	public By getLupa() {
		return lupa;
	}

	private By facaLogin = By.xpath("//*[@id=\"fixed-container-styles\"]/header/div/div[2]/div[2]/div/div[3]/button");

	public By getFacaLogin() {
		return facaLogin;
	}

	private By meuPedidos = By.cssSelector("#fixed-container-styles > header > div > div.sc-giYgFv.cqRVfg");

	public By getMeuPedidos() {
		return meuPedidos;
	}

	// Acesso a conta

	private By emCpf = By.id("emailCpf");

	public By getEmCpf() {
		return emCpf;
	}

	private By senha = By.id("password");

	public By getSenha() {
		return senha;
	}

	private By btnFacaLogin = By.xpath("//*[@id=\"__next\"]/main/div/div/div[2]/div[1]/div[1]/form/button");

	public By getBtnFacaLogin() {
		return btnFacaLogin;
	}
	
	public By getAcessoMeusPedidos() {
		return acessoMeusPedidos;
	}

	private By acessoMeusPedidos = By.cssSelector("#myAccountMenu > div > ul > li:nth-child(3) > a > div");
}