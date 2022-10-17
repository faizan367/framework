package practice;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Java_Utility;

public class CreateOrganizationHardcode {

			public static void main(String[] args) throws Throwable {

			String Key="webdriver.chrome.driver";
			String value= "./chromedriver.exe";
			//String value="E:\\java\\oop\\com.crm.farmework\\chromedriver.exe";
			System.setProperty(Key, value);
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			File_utility flib=new File_utility();
			String URL=flib.getPropertyKeyValue("url");
			String UserName = flib.getPropertyKeyValue("un");
			String PassWord = flib.getPropertyKeyValue("pw");
			
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(UserName);
			driver.findElement(By.name("user_password")).sendKeys(PassWord);
			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			Java_Utility jlib=new Java_Utility();
			int rnam = jlib.getRanDomNum();
			
			
			 Excel_utility xlib=new  Excel_utility();
			 String data=xlib.getDataFromExcel("organization", 0, 0)+rnam;
			FileInputStream fis1=new FileInputStream("C:\\Users\\faizan alam\\Downloads\\Book2.xlsx");

			Workbook book=WorkbookFactory.create(fis1);

			Sheet sh = book.getSheet("organization");

			Row row = sh.getRow(0);

			Cell cel = row.getCell(0);

			data = cel.getStringCellValue();
			driver.findElement(By.name("accountname")).sendKeys(data);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			Thread.sleep(1000);
			//Assert.assertEquals(true, false);
			String actData = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
           // Assert.assertEquals(actData, data);
			if(actData.contains(data))
			{
			System.out.println("pass");
			}
			else
			{
			System.out.println("fail");
			}
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

			}
			
		
}
