package com.crm.jenericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectReposatory.CreateCampaign;
import com.crm.ObjectReposatory.HomePage;
import com.crm.ObjectReposatory.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver sDriver;
public WebDriver driver;
	
	@BeforeSuite(groups= {"smokeTest","regretionTest"})
public void BS() {
	System.out.print("for database connection");
}
	@BeforeTest(groups= {"smokeTest","regretionTest"})
public void BT() {
	System.out.print("for execute in parallel mode");
}
	@Parameters("BROWSER")//for cross browser
	@BeforeClass(groups= {"smokeTest","regretionTest"})
public void BC(String BROWSER) throws Throwable {
		  File_utility fut1=new File_utility();
	      Excel_utility xlu=new Excel_utility();
	      Webdriver_utility  weu=new Webdriver_utility();   
	      Java_Utility jlib=new Java_Utility();
	      
	       String Browser = fut1.getPropertyKeyValue("browser");    
	     
	      
	        if(BROWSER.equalsIgnoreCase("chrome")) {
	          WebDriverManager.chromedriver().setup();
	          driver=new ChromeDriver();
	        }
	        else if(BROWSER.equalsIgnoreCase("firefox")) {
	          WebDriverManager.firefoxdriver().setup();
	          driver=new FirefoxDriver();
	          
	        }
	        else if(BROWSER.equalsIgnoreCase("edge")) {
	          WebDriverManager.firefoxdriver().setup();
	          driver=new EdgeDriver();
	        }
	        else {
	          driver=new ChromeDriver();
	        }
	        sDriver=driver;          
	      
	System.out.print("for launching browser");
}
	@BeforeMethod(groups= {"smokeTest","regretionTest"})
public void BM() throws Throwable {
	 	
			File_utility flib=new File_utility();
			String URL = flib.getPropertyKeyValue("url");
			String uSERnAME = flib.getPropertyKeyValue("un");
			String PassWord = flib.getPropertyKeyValue("pw");
			  driver.get(URL);
		       LoginPage login=new LoginPage(driver);
		       login.login(uSERnAME, PassWord);      
		      
	System.out.print("for login to application");
}
	@AfterMethod(groups= {"smokeTest","regretionTest"})
public void AM() {
		
	System.out.print("for logout the  application");
}
	@AfterClass(groups= {"smokeTest","regretionTest"})
public void AC() {
	System.out.print("for close browser");
}
	@AfterTest(groups= {"smokeTest","regretionTest"})
public void AT() {
	System.out.print("for executed successfully");
}
	@AfterSuite(groups= {"smokeTest","regretionTest"})
public void AS() {
	System.out.print("for database closed");
}
}