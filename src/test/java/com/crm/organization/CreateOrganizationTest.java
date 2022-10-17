package com.crm.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectReposatory.CreateCampaign;
import com.crm.ObjectReposatory.CreationOrganization;
import com.crm.ObjectReposatory.HomePage;
import com.crm.ObjectReposatory.LoginPage;
import com.crm.jenericutility.BaseClass;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Java_Utility;
import com.crm.jenericutility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class CreateOrganizationTest extends BaseClass {
	@Test(groups= {"smokeTest","regretionTest"})
	public void createOrganizationTest () throws Throwable {
		   // public static void main(String[] args) throws Throwable {
		    File_utility flib=new File_utility();
		 	String URL = flib.getPropertyKeyValue("url");
		 	String uSERnAME = flib.getPropertyKeyValue("un");
		 		String PassWord = flib.getPropertyKeyValue("pw");
				
		    File_utility fut=new File_utility();
		    Excel_utility xlu=new Excel_utility();
		    Webdriver_utility  weu=new Webdriver_utility();
		    Java_Utility jlib=new Java_Utility();
		    weu.waitForPageToLoad(driver); 
		      
		   /* String BROWSER = fut.getPropertyKeyValue("browser");
		    WebDriver driver;
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
		    
		    // String URL=xlu.getExelKeyValue("sheet1", 1, 2);  
		    // String USERNAME=xlu.getExelKeyValue("sheet1", 1, 3);
		    //  String PASSWORD=xlu.getExelKeyValue("sheet1", 1, 4);
		    //  String data=xlu.getExelKeyValue("sheet1", 1, 5);   
		  
		    //maximizing window
		    weu.maximizebrowser(driver);
		    
		    //implicitly wait
		    weu.implicittWait(driver);
		    
		     driver.get(URL);
		     LoginPage login=new LoginPage(driver);
		     login.login(uSERnAME, PassWord);
		     
		  /*   driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		     driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		    WebElement submitbutton= driver.findElement(By.id("submitButton"));
		    
		    
		    //Taking ScrenShot of submit button
		    weu.TakesWebElementScreenShoot(submitbutton);
		    submitbutton.click();   */
		    
		  /* //creating organisation
		        driver.findElement(By.linkText("Organizations")).click();
		     driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		     driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("mnm3");
		       driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		       //for the log out
		       Thread.sleep(5000);
		     driver.findElement(By.xpath("//td[@valign='bottom']/../..//img[@src='themes/softed/images/user.PNG']")).click();
		         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();  */
		     
		     
		     
		     HomePage hl=new HomePage(driver);  
		     hl.OrganisationLinkInHome();
		     //Assert.assertEquals(true, false);
		     
		     CreationOrganization os=new CreationOrganization(driver);
		     os.Organisation("hjl1");
		     SoftAssert s=new SoftAssert();
		    // s.assertEquals("A","B");
		     s.assertAll();
		    hl.AdministrationInHomePage();
		    hl.LogOutButton();}
	            
	@Test	    
	public void modifiedOrg() {
		
		System.out.print("org modified");
	}
	
		}

