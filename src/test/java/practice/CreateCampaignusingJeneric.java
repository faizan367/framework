package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.jenericutility.File_utility;

public class CreateCampaignusingJeneric {
	public static void main(String[] args) throws Throwable  {		
		System.setProperty("Webdriver.chrome.driver", "./target/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		File_utility flib=new File_utility();
		String URL = flib.getPropertyKeyValue("url");
		String uSERnAME = flib.getPropertyKeyValue("un");
		String PassWord = flib.getPropertyKeyValue("pw");
		
		//FileInputStream fis=new FileInputStream("./commondata.properties.txt");
		//Properties ps=new Properties();
		//ps.load(fis);
		//String URL = ps.getProperty("url");
		//String UserName = ps.getProperty("un");
		//String password = ps.getProperty("pw");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(uSERnAME);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
      // go to more
		   WebElement more = driver.findElement(By.xpath("//a[@href='javascript:;']"));
		   Actions action=new Actions(driver);
		   action.moveToElement(more).perform();
	
		    driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		          driver.findElement(By.name("campaignname")).sendKeys("faizan alan");
		          
		        
		     
		    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		          driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		   
	}

}