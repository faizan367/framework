package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.jenericutility.File_utility;

public class DataproviderTest1 {
	@Test(dataProvider="dataProvider_test")
public void companydetails(String name,String phno,String email) throws Throwable {
	String key="webdriver.chrome.driver";
	String value="./target/chromedriver.exe";
	System.setProperty(key,value);
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	  // File_utility flib=new File_utility();
	 //String URL = flib.getPropertyKeyValue("url");
	 //	String uSERnAME = flib.getPropertyKeyValue("un");
	 //	String PassWord = flib.getPropertyKeyValue("pw");
	 		
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("firstname")).sendKeys(name);
	driver.findElement(By.id("mobile")).sendKeys(phno);
	driver.findElement(By.id("email")).sendKeys(email);
	driver.quit();
	Thread.sleep(2000);
}
	@DataProvider
public Object[][] dataProvider_test(){
	Object[][]objArr=new Object[5][2];
	objArr[0][0]="banglore";
	objArr[1][1]="goa";
	
	objArr[1][0]="banglore";
	objArr[1][1]="maisore";
	
	objArr[2][0]="banglore";
	objArr[2][1]="manglore";
	
	objArr[3][0]="banglore";
	objArr[3][1]="mumbai";
	
	objArr[4][0]="banglore";
	objArr[4][1]="kochi";
	return objArr;
	
}
}

