package practice;

import org.openqa.selenium.edge.EdgeDriver;

public class LonchMsEdge {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver","./msedgedriver.exe");
		new EdgeDriver();

			Thread.sleep(2000);

		}


	}

