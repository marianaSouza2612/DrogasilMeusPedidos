package Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Metodos {

	WebDriver driver;

	/**
	 * Abrir navegador e site
	 * 
	 * @param site
	 * @param navegador
	 * @param descricaoPasso
	 * @throws IOException
	 */

	// para abrir o Browser
	public void abrirCHROME(String Site, String DescricaoPasso) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Site);
		driver.manage().window().maximize();
	}

	public void abrirFIRE(String Site, String descricaoPasso) {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(Site);
		driver.manage().window().maximize(); 
	}

	/**
	 * Fechar Navegador
	 * 
	 * @author Thiago de Souza
	 * @param descricaoPasso
	 * @throws IOException
	 */

	public void fecharNavegador(String descricaoPasso) throws IOException {

		try {
			driver.quit();
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Print Screen de Erros
	 * 
	 * @author Thiago de Souza
	 * @param nomePrint
	 * @throws IOException
	 */

	/**
	 * Print Screen de Erros
	 * 
	 * @author Thiago de Souza
	 * @param nomePrint
	 * @throws IOException
	 */

	public void printScreenErros(String descricaoPasso) throws IOException {

		TakesScreenshot print = ((TakesScreenshot) driver);
		File SrcFile = print.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./src/Evidências/Erros/" + descricaoPasso + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}

	/**
	 * Escrever
	 * 
	 * @author Thiago de souza
	 * @param elemento
	 * @param texto
	 * @param descricaoPasso
	 * @throws IOException
	 */

	public void escrever(By elemento, String texto, String descricaoPasso) throws IOException {

		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Clicar
	 * 
	 * @author Thiago de Souza
	 * @param elemento
	 * @param descricaoPasso
	 * @throws IOException
	 */

	public void clicar(By elemento, String descricaoPasso) throws IOException {

		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Submit
	 * 
	 * @author Thiago de Souza
	 * @param elemento
	 * @param descricaoPasso
	 * @throws IOException
	 */

	public void submit(By elemento, String descricaoPasso) throws IOException {

		try {
			driver.findElement(elemento).submit();
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Super Click
	 * 
	 * @author Thiago de Souza
	 * @param elemento
	 * @param descricaoDoPasso
	 * @throws IOException
	 */

	public void superClick(By elemento, String descricaoPasso) throws IOException {

		try {
			superClick((By) driver.findElement(elemento), descricaoPasso);
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Clicar no Texto
	 * 
	 * @author Thiago de Souza
	 * @param text
	 * @param descriPasso
	 * @throws IOException
	 */

	public void clicarText(String text, String descricaoPasso) throws IOException {

		try {
			driver.findElement(By.linkText(text)).click();
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Duplo Click
	 * 
	 * @author Thiago de Souza
	 * @param elemento
	 * @param descricaoDoPasso
	 * @throws IOException
	 */

	public void duploCliqueNoElemento(By elemento, String descricaoPasso) throws IOException {

		long TIMEOUT = 40;
		Actions action = new Actions(driver);
		try {
			driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
			action.doubleClick(
					new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(elemento)));
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Esperar ser clicável
	 * 
	 * @author Thiago de Souza
	 * @param elemento
	 * @param descricaoPasso
	 * @throws IOException
	 */

	public void esperarClicavel(By elemento, String descricaoPasso) throws IOException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement el = wait.until(ExpectedConditions.elementToBeClickable(elemento));
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Esperar Escrever Elemento Presente na Tela
	 * 
	 * @author Thiago de Souza
	 * 
	 * @param element
	 * @param descricaoPasso
	 * @throws IOException
	 */

	public void esperarEscrever(By element, String descricaoPasso) throws IOException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			boolean elemento = wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

	/**
	 * Pausa
	 * 
	 * @author Thiago de souza
	 * @param tempo
	 * @param descricaoPasso
	 * @throws InterruptedException
	 * @throws IOException
	 */

	public void pausa(int tempo, String descricaoPasso) throws InterruptedException, IOException {

		try {
			Thread.sleep(tempo);
		} catch (Exception e) {
			printScreenErros("Erro ao tentar -- " + descricaoPasso);

		}
	}

}
