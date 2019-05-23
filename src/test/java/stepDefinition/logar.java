package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class logar {
	private WebDriver navegador;
	@Given("^Que eu esteja na pagina do Submarino$")
	
	public void que_eu_esteja_na_pagina_do_Submarino() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Will\\Desktop\\automacao_selenium\\src\\test\\java\\suporte\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        // Navegando para a pagina do olx
        navegador.get("https://www.submarino.com.br/");
        navegador.manage().window().maximize();
		
	}

	@When("^acessar a pagina de login$")
	public void acessar_a_pagina_de_login() throws Throwable {
		
		Actions actions = new Actions(navegador);
        WebElement menu = navegador.findElement(By.id("h_user"));
        actions.moveToElement(menu).pause(1000);
        
        
         WebElement subMenu = navegador.findElement(By.id("h_usr-signin"));
         actions.moveToElement(subMenu);
         actions.click().build().perform();
        
		
	}

	@When("^clicar em continuar$")
	public void clicar_em_continuar() throws Throwable {
	}

	@Then("^aparece a mensagem 'E-mail ou senha incorretos'$")
	public void aparece_a_mensagem_E_mail_ou_senha_incorretos() throws Throwable {
		navegador.quit();
	}
	
	@When("^inserir minhas informacoes$")
	public void inserirMinhasInformacoes() throws Throwable {
	}

	@When("^inserir minhas informacoes incorretas$")
	public void inserirMinhasInformacoesIncorretas() throws Throwable {
	}
	
	@Then("^aparece a informacao 'Ola Nome'$")
	public void apareceAInformacaoOlaNome() throws Throwable {
		navegador.quit();
	}

}
