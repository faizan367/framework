package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectReposatory.HomePage;
import com.crm.ObjectReposatory.LoginPage;
import com.crm.ObjectReposatory.ProductScript;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProductPom {
	  public static void main(String[] args) throws Throwable {
		  
		  File_utility flib=new File_utility();
			String URL = flib.getPropertyKeyValue("url");
			String uSERnAME = flib.getPropertyKeyValue("un");
			String PassWord = flib.getPropertyKeyValue("pw");
			
	      File_utility fut=new File_utility();
	      Excel_utility xlu=new Excel_utility();
	      Webdriver_utility  weu=new Webdriver_utility ();
	     
	      
	       String BROWSER = fut.getPropertyKeyValue("browser");
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
	      
	      //  String URL=xlu.getExelKeyValue("sheet1", 1, 2);  
	      //  String USERNAME=xlu.getExelKeyValue("sheet1", 1, 3);
	      //   String PASSWORD=xlu.getExelKeyValue("sheet1", 1, 4);
	      //  String data=xlu.getExelKeyValue("sheet1", 1, 5);   
	    
	      //maximizing window
	      weu.maximizebrowser(driver);
	      
	      //implicitly wait
	      weu.implicittWait(driver);
	      
	       driver.get(URL);
	       LoginPage login=new LoginPage(driver);
	       login.login(uSERnAME, PassWord);
	       
	       HomePage hp=new HomePage(driver);
	       hp.product_inHomePageMethod();
	       
	       ProductScript pss=new ProductScript(driver);
	       pss.Deleteproduct();
	       
	       weu.switchToAlertAndDismiss(driver);
	       Thread.sleep(5500);
	       
	       hp.AdministrationInHomePage();
	       hp.LogOutButton();
	       
	    
	  }
	}