/**
* @file	    TestSiteUfrn.java
* @author   Valmir Correa (valmir.correa@ufrn.edu.br)
* @date	    09/2018
*/

//Importa as bibliotecas do JUnit
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

//Importa as bibliotecas do Selenium WebDriver
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Testes no site da oficial da UFRN utilizando o geckodriver
 */
public class TestSiteUfrn {

	/* Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver. */
	private WebDriver driver;
	/* Local do driver */
	private String driverPath = "/home/valmir/Downloads/geckodriver";
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Inicia tudo que for necessário para o teste e cria uma instância do navegador
	 * e abre a página inicial do Portal da UFRN.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando o browser Firefox");
		System.out.println("Acessando o Potal da UFRN");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		baseUrl = "https://www.ufrn.br/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Testa título 'Portal da UFRN'
	 */
	@Test
	public void testaTituloDaPagina() {
		assertEquals("Portal da UFRN", driver.getTitle());
	}

	/**
	 * Testa a caixa de pesquisa do Portal.
	 */
	// @Test
	// public void testPesquisaNoPortalUfrn() {
	//
	// // Instancia um novo objeto do tipo "WebElement", e passa como parâmetro
	// // um elemento da tela cujo valor do atributo "id" seja igual a
	// "menuPesquisa".
	// WebElement element =
	// driver.findElement(By.xpath("//ul[@id='menuPesquisa']/li[2]/a/span"));
	//
	// // Insere dados no elemento "usuario".
	// element.sendKeys("instituto metropole digital");
	//
	// // Clica no botão "Pesquisar"
	// driver.findElement(By.id("btn-search-modal")).click();
	// }

	/**
	 * Finaliza o teste, fechando a instância do WebDriver.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
