package com.crm.campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectReposatory.CreateCampaign;
import com.crm.ObjectReposatory.HomePage;
import com.crm.ObjectReposatory.IntigrationScript;
import com.crm.ObjectReposatory.LoginPage;
import com.crm.jenericutility.BaseClass;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntegrationScrPtTest extends BaseClass {
	@Test(groups= {"regretionTest"})

		  public void integrationScrPtTest() throws Throwable {
		  /*  String path="./Book1.xlsx";

		    FileInputStream fis=new FileInputStream(path);
		    Workbook book = WorkbookFactory.create(fis);

		    String KEY      = book.getSheet("Sheet1").getRow(3).getCell(0).getStringCellValue();
		    String VALUE    = book.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
		    String URL      = book.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue();
		    String USERNAME = book.getSheet("Sheet1").getRow(3).getCell(3).getStringCellValue();
		    String PASSWORD = book.getSheet("Sheet1").getRow(3).getCell(4).getStringCellValue();
		    String data     = book.getSheet("Sheet1").getRow(3).getCell(5).getStringCellValue();

		     System.setProperty(KEY, VALUE);
		     WebDriver driver=new ChromeDriver();
		     //implicitlyWait
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     //login in vtiger
		     driver.get(URL);
		     driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		     driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		     driver.findElement(By.id("submitButton")).click();
		     //added mouse houwering
		     WebElement more = driver.findElement(By.xpath("//a[@href='javascript:;']"));
		     Actions action=new Actions(driver);
		     action.moveToElement(more).perform();
		      driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		    
		     //creating campain
		         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		          driver.findElement(By.name("campaignname")).sendKeys("mjg1");
		        //adding product
		          driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		          //transforming control
		        Set<String> windowids = driver.getWindowHandles();
		          Iterator <String> stovered=windowids.iterator();
		          String parentwindow=stovered.next();
		          String childwindow=stovered.next();
		          driver.switchTo().window(childwindow);   
		          
		          driver.findElement(By.linkText("ndt1")).click();
		          driver.switchTo().window(parentwindow);   
		          
		      WebElement_utility weu=new WebElement_utility();
		          weu.switchTowindow(driver,"module=Products&action" )  ;
		      
		          driver.findElement(By.xpath("input[@class='crmbutton small save']")).click();
		        //for the log out
		      driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		          driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		         
		          ck();   */
			  File_utility flib=new File_utility();
				String URL = flib.getPropertyKeyValue("url");
				String uSERnAME = flib.getPropertyKeyValue("un");
				String PassWord = flib.getPropertyKeyValue("pw");
				
				
		      File_utility fut1=new File_utility();
		      Excel_utility xlu=new Excel_utility();
		      Webdriver_utility  weu=new Webdriver_utility ();
		     
		      
		       String BROWSER = fut1.getPropertyKeyValue("browser");
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
		      }
		      
		      // String URL=xlu.getExelKeyValue("sheet1", 1, 2);  
		      // String USERNAME=xlu.getExelKeyValue("sheet1", 1, 3);
		      //  String PASSWORD=xlu.getExelKeyValue("sheet1", 1, 4);
		      // String data=xlu.getExelKeyValue("sheet1", 1, 5);  
		    
		      //maximizing window
		      weu.maximizebrowser(driver);
		      
		      //implicitly wait
		      weu.implicittWait(driver);
		      
		       driver.get(URL);
		       LoginPage login=new LoginPage(driver);
		       login.login(uSERnAME, PassWord);      
		       
		         HomePage hp4=new HomePage(driver);
		         hp4.MoreLimk_HomePage(driver);
		         hp4.CampainLink_inHomepageMetod();
		         CreateCampaign cs1=new CreateCampaign(driver);
		         cs1.CampainNotSubmittButton("kjv9");
		         IntigrationScript is=new IntigrationScript(driver);
		         is.Intigration(driver, "ndt1");
		         hp4.AdministrationInHomePage();
		         hp4.LogOutButton();
		         
		          
		  }

		}
