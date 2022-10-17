package practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class LonchEmptyBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		new ChromeDriver();
		Thread.sleep(2000);

	}

}
