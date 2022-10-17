package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTimeParameterTest {
	
	@Test(groups="regretionTest")
	public void mothod() {
		String BROWSER=System.getProperty("browser");
		System.out.print(BROWSER);
		
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();	
		
	}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
			
		}
		else {
			driver=new ChromeDriver();
		}
		}
}
		
