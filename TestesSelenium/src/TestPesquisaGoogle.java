import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Simples teste para realizar uma pesquisa no goole
 * usando o geckodriver para o Firefox
 * @author Valmir Correa (valmir.correa@ufrn.edu.br)
 * Artigo sober webdriver: https://www.devmedia.com.br/introducao-aos-testes-funcionais-automatizados-com-junit-e-selenium-webdriver/28037
 */
public class TestPesquisaGoogle {

	/* Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver. */
	private WebDriver driver;
	/* Local do driver */
	private String driverPath = "/home/valmir/Downloads/geckodriver"; 
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	  /**
	   * Inicia tudo que for necessário para o teste e cria 
	   * uma instância do navegador e abre a página inicial da UFRN.
	   * @throws Exception
	   */
	  @Before
	  public void setUp() throws Exception {
	   System.out.println("Iniciando o browser Firefox");
	   System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
	    baseUrl = "https://www.google.com.br/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	  /**
	   * Pesquisa no google a palavra "ufrn"
	   * @throws Exception
	   */
	  @Test
	  public void testPesquisaGoogle() throws Exception {
		System.out.println("Teste de Pesquisa Google");
	    driver.get(baseUrl);
	    driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys("ufrn");
	    driver.findElement(By.name("btnK")).click();
	    
	  }

	  /**
	   * Finaliza o teste, fechando a instância do WebDriver.
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