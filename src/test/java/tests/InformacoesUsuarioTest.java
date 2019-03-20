package tests;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTestData.csv")

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp()
    {
        // Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\739165\\Documents\\drivers/chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a pagina do olx
        navegador.get("http://www.juliodelima.com.br/taskit");

        // Clicar no link que possui o "SIGN IN"
        navegador.findElement(By.linkText("Sign in")).click();

        // Identificando o formulario de login
        // Identificando o formulario de login
        // Identificando o formulario de login
        // Identificando o formulario de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo com nome "login" que está dentro do formulario de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Digitar no campo com nome "password" que está dentro do formulario de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"

        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Test
    //testing
    public void testAdicionarUmaInformacaoAdicionalDoUsuario (@Parameterized.Parameters(name="tipo")String tipo, @Parameterized.Parameters(name="contato")String contato, @Parameterized.Parameters(name="mensagemEsperada")String mensagemEsperada)
            {

        // Clicar no botão através do XPATH //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulario de id addmoredata
        WebElement popUpAddMoreData = navegador.findElement(By.id("addmoredata"));

        // No combo de name "type" escolhe a opção PHONE
        WebElement campoType = popUpAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // No campo de name "contact' digitar "+5511999991111"
        popUpAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que está no POPUP
        popUpAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de ID "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemEsperada, mensagem);
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



