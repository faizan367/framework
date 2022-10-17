package com.crm.product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectReposatory.HomePage;
import com.crm.ObjectReposatory.LoginPage;
import com.crm.ObjectReposatory.ProductScript;
import com.crm.jenericutility.BaseClass;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass {
	@Test(groups= {"regretionTest"})
	 public  void createProductTest() throws Throwable {

		 /* System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			File_utility fut=new File_utility();
		    WebElement_utility wu=new WebElement_utility();
		    
		    String path="./Book1.xlsx";

		    FileInputStream fis=new FileInputStream(path);
		    Workbook book = WorkbookFactory.create(fis);

		    String KEY      = book.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		    String VALUE    = book.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		    String URL      = book.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		    String USERNAME = book.getSheet("Sheet1").getRow(2).getCell(3).getStringCellValue();
		    String PASSWORD = book.getSheet("Sheet1").getRow(2).getCell(4).getStringCellValue();
		    String data = book.getSheet("Sheet1").getRow(2).getCell(5).getStringCellValue();

		     System.setProperty(KEY, VALUE);
		     WebDriver driver=new ChromeDriver();
		     //implicitlyWait
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    //login in vtiger
		     driver.get(URL);
		     driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		     driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		     driver.findElement(By.id("submitButton")).click();
		     //creating organisation
		         driver.findElement(By.linkText("Products")).click();
		     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		     driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
		       driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		       //for the log out
		     driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		         driver.findElement(By.xpath("//a[text()='Sign Out']")).click();    */
		 File_utility flib=new File_utility();
			String URL = flib.getPropertyKeyValue("url");
			String uSERnAME = flib.getPropertyKeyValue("un");
			String PassWord = flib.getPropertyKeyValue("pw");
			
			
		      File_utility fut1=new File_utility();
		        Excel_utility xlu=new Excel_utility();
		       Webdriver_utility weu = new Webdriver_utility();
		        
		         String BROWSER = fut1.getPropertyKeyValue("browser");
		        WebDriver driver1;
		        if(BROWSER.equalsIgnoreCase("chrome")) {
		          WebDriverManager.chromedriver().setup();
		          driver1=new ChromeDriver();
		        }
		        else if(BROWSER.equalsIgnoreCase("firefox")) {
		          WebDriverManager.firefoxdriver().setup();
		          driver1=new FirefoxDriver();
		          
		        }
		        else if(BROWSER.equalsIgnoreCase("edge")) {
		          WebDriverManager.firefoxdriver().setup();
		          driver1=new EdgeDriver();
		        }
		        else {
		          driver1=new ChromeDriver();
		        }
		        
		      
		        //  String URL=xlu.getExelKeyValue("sheet1", 1, 2);  
		        //  String USERNAME=xlu.getExelKeyValue("sheet1", 1, 3);
		        //  String PASSWORD=xlu.getExelKeyValue("sheet1", 1, 4);
		        //  String data=xlu.getExelKeyValue("sheet1", 1, 5);  
		      
		        //maximizing window
		        weu.maximizebrowser(driver1);
		        
		        //implicitly wait
		        weu.implicittWait(driver1);
		        
		         driver1.get(URL);
		         LoginPage login=new LoginPage(driver1);
		         login.login(uSERnAME, PassWord);      
		         
		         
		        HomePage hp1=new HomePage(driver1); 
		        hp1.product_inHomePageMethod();
		        
		        ProductScript pr=new ProductScript(driver1);
		        pr.product("kml5");
		        hp1.AdministrationInHomePage();
		        hp1.LogOutButton();
		           
		    
		  }
@Test
	private void modifiyProduct() {
		// TODO Auto-generated method stub
		
	}

		}
