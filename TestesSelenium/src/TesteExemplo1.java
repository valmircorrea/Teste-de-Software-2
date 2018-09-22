import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


//https://www.seleniumhq.org/docs/03_webdriver.jsp
public class TesteExemplo1 {


	private String driverPath = "/home/valmir/Downloads/geckodriver";
	private WebDriver driver;

	@Test
	public void testFire() {
	
		System.out.println("Iniciando o browser Firefox");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        
        // Enter something to search for
        element.sendKeys("Cheese!");
        
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
 
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
    }
	

	@Test 
	public void testGooglePageTitleInIEBrowser() {
		System.out.println("Iniciando o browser Chrome");
		System.setProperty("webdriver.firefox.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		assertEquals(strPageTitle,"Google");
	}


}
