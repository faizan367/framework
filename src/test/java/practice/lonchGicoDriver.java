package practice;

import org.openqa.selenium.firefox.FirefoxDriver;

public class lonchGicoDriver {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
		new FirefoxDriver();
			Thread.sleep(2000);

		}
	
	}

