package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Java_Utility;
import com.crm.jenericutility.Webdriver_utility;

public class DeleteProductUseJeneric {
	public static void main(String[] args) throws Throwable {
		System.setProperty("Webdriver.chrome.driver", "./target/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Excel_utility elib=new Excel_utility();
		File_utility flib =new File_utility();
		Java_Utility jlib=new Java_Utility();
		Webdriver_utility wlib=new Webdriver_utility();
		
		String URL = flib.getPropertyKeyValue("url");
		String userNmae = flib.getPropertyKeyValue("un");
		String pasWrd = flib.getPropertyKeyValue("pw");
		
		
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(userNmae);
		driver.findElement(By.name("user_password")).sendKeys(pasWrd);
		driver.findElement(By.id("submitButton")).click();
		
		//go to product and click add button
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//fetch data from excel anad save and then delete
		
		int rnam = jlib.getRanDomNum();
		
		String ProdData = elib.getDataFromExcel("Product", 0, 0)+rnam;
		driver.findElement(By.name("productname")).sendKeys(ProdData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("(//input[@title='Delete [Alt+D]'])[1]")).click();
		
		//use web driver utiliy
		wlib.switchToAlertAndAccpect(driver);
		
		//use sign out
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}