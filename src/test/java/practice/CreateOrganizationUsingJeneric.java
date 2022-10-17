

package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.ObjectReposatory.LoginPage;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.google.common.collect.Table.Cell;
import com.mysql.cj.result.Row;

import com.crm.jenericutility.Java_Utility;

public class CreateOrganizationUsingJeneric {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		File_utility flib=new File_utility();
		String URL = flib.getPropertyKeyValue("url");
		String userName = flib.getPropertyKeyValue("un");
		String paswd = flib.getPropertyKeyValue("pw");
		
		
		//FileInputStream fis=new FileInputStream("./commondata.properties.txt");
		//Properties ps=new Properties();
		//ps.load(fis);
		//String URL = ps.getProperty("url");
		//String UserName = ps.getProperty("un");
		//String password = ps.getProperty("pw");
		
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.login(userName, paswd);
		
		/*driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(paswd);
		driver.findElement(By.id("submitButton")).click();*/
		

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int rnam = jlib.getRanDomNum();
		
		Excel_utility elib = new Excel_utility();
		String orgdata = elib.getDataFromExcel("organization", 0, 0)+rnam;
		driver.findElement(By.name("accountname")).sendKeys(orgdata);
		//driver.close();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		 }

}