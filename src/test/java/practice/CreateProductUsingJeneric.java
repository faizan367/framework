package practice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.jenericutility.File_utility;

import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.Java_Utility;

public class CreateProductUsingJeneric {
	public static void main(String[] args) throws Throwable {
		System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		File_utility flib=new File_utility();
		String URL = flib.getPropertyKeyValue("url");
		String uSERnAME = flib.getPropertyKeyValue("un");
		String PassWord = flib.getPropertyKeyValue("pw");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(uSERnAME);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.cssSelector("a[href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int rnam = jlib.getRanDomNum();
		
		Excel_utility elib=new Excel_utility();
		String data = elib.getDataFromExcel("product", 0, 0)+rnam;
		
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		String actualData = driver.findElement(By.xpath("//td[@class='dvtSelectedCell']")).getText();
		if(actualData.contains(data)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
	

}
