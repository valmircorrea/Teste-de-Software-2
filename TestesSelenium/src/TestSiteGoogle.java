/**
* @file	    TestSiteUfrn.java
* @author   Valmir Correa (valmir.correa@ufrn.edu.br)
* @date	    09/2018
*/

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Testes no site da google utilizando o geckodriver
 */
public class TestSiteGoogle {
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
System.setProperty("webdriver.gecko.driver", driverPath);
	driver = new FirefoxDriver();
    baseUrl = "https://www.google.com.br/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  /**
   * Testa a pagina do Google
   * @throws Exception
   */
  @Test
  public void testSiteGoogle() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("portal inova");
    
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

public boolean isAcceptNextAlert() {
	return acceptNextAlert;
}

public void setAcceptNextAlert(boolean acceptNextAlert) {
	this.acceptNextAlert = acceptNextAlert;
}

 
}
