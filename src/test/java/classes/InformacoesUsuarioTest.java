package classes;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp()
    {
        // Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Will\\Desktop\\automacao_selenium\\src\\test\\java\\suporte\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a pagina do olx
        navegador.get("https://www.submarino.com.br/");

        // Clicar no link que possui o "SIGN IN"
        

        Actions actions = new Actions(navegador);
        WebElement menu = navegador.findElement(By.id("h_user"));
        actions.moveToElement(menu);

        WebElement subMenu = navegador.findElement(By.id("h_usr-signin"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
        
        
        
    }

  

    @Test
    public void removerUmContatoDeUmUsuario()
    {

            // clicar no elemento pelo seu xpath //span[text()="+556166664444"]/following-sibling::a
            navegador.findElement(By.xpath("//span[text()=\"+556166664444\"]/following-sibling::a")).click();

            // Confirmar a janela javascript
            navegador.switchTo().alert().accept();

            // Validar que a mensagem apresentada foi Rest in peace, dear phone!
            WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
            String mensagem = mensagemPop.getText();
            assertEquals("Rest in peace, dear phone!", mensagem);


            String screenshotArquivo = "C:\\Users\\739165\\Desktop\\Treinamento - Selenium webdriver\\test-report/taskit/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
            Screenshot.tirar(navegador, screenshotArquivo);


            // Aguardar 10 segundos para que a janela desapareça
            WebDriverWait aguardar = new WebDriverWait(navegador,   10);
            aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

            // Clicar no link contexto logout
            navegador.findElement(By.linkText("Logout")).click();
        }

    @After
    public void tearDown()
    {
        // Fechar o navegador
          navegador.quit();
    }
}



