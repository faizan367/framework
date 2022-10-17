package com.crm.campaign;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.ObjectReposatory.CreateCampaign;
import com.crm.ObjectReposatory.HomePage;
import com.crm.ObjectReposatory.LoginPage;
import com.crm.jenericutility.BaseClass;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Java_Utility;
import com.crm.jenericutility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass {
@Test(groups= {"smokeTest","regretionTest"})
  public void createCampaignTest() throws Throwable {
	  //	System.setProperty("Webdriver.chrome.driver", "./target/chromedriver.exe");
	  //	WebDriver driver=new ChromeDriver();
	  //	driver.manage().window().maximize();
	  //	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//FileInputStream fis=new FileInputStream("./commondata.properties.txt");
		//Properties ps=new Properties();
		//ps.load(fis);
		//String URL = ps.getProperty("url");
		//String UserName = ps.getProperty("un");
		//String password = ps.getProperty("pw");
		
		 //driver.get(URL);
		 //driver.findElement(By.name("user_name")).sendKeys(uSERnAME);
		 //driver.findElement(By.name("user_password")).sendKeys(PassWord);
		 //driver.findElement(By.id("submitButton")).click();
      // go to more
		 // WebElement more = driver.findElement(By.xpath("//a[@href='javascript:;']"));
		 //  Actions action=new Actions(driver);
		 //  action.moveToElement(more).perform();
	
		 //   driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		 //       driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 //       driver.findElement(By.name("campaignname")).sendKeys("faizan alan");
		          
		        
		     
		 //   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 //        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		   
    
      
        //  String URL=xlu.getExelKeyValue("sheet1", 1, 2);  
        //    String USERNAME=xlu.getExelKeyValue("sheet1", 1, 3);
        //    String PASSWORD=xlu.getExelKeyValue("sheet1", 1, 4);
        //   String data=xlu.getExelKeyValue("sheet1", 1, 5);  
	
      
      File_utility flib=new File_utility();
	 	String URL = flib.getPropertyKeyValue("url");
	 	String uSERnAME = flib.getPropertyKeyValue("un");
	 		String PassWord = flib.getPropertyKeyValue("pw");
			
	    File_utility fut=new File_utility();
	    Excel_utility xlu=new Excel_utility();
	    Webdriver_utility  weu=new Webdriver_utility();
	    Java_Utility jlib=new Java_Utility();
	    weu.waitForPageToLoad(driver); 
	    
      /*  String BROWSER = fut1.getPropertyKeyValue("browser");    
     
      
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
        } */
      
   
	//maximizing window
      weu.maximizebrowser(driver);
      
      //implicitly wait
      weu.implicittWait(driver);
      //Login Page
     
       //HOMEpage
      HomePage hp2=new HomePage(driver); 
      
      hp2.MoreLimk_HomePage(driver);
        hp2.CampainLink_inHomepageMetod();
        
        CreateCampaign cs=new CreateCampaign(driver);
      cs.CampainWithSubmittButton("jjf3");
      
      hp2.AdministrationInHomePage();
      hp2.LogOutButton();
   
  }

}

