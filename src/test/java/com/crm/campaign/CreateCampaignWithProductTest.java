package com.crm.campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.jenericutility.BaseClass;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Java_Utility;
import com.crm.jenericutility.Webdriver_utility;
public class CreateCampaignWithProductTest extends BaseClass {
@Test(groups= {"smokeTest"})
	public void createCampaignWithProductTest() throws Throwable {
		Excel_utility Elib=new Excel_utility();
		File_utility flib1=new File_utility();
		Java_Utility jlib=new Java_Utility();
		Webdriver_utility wlib=new Webdriver_utility();
		
		 System.setProperty("Webdriver.chrome.driver", "./chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		File_utility flib=new File_utility();
		String URL = flib.getPropertyKeyValue("url");
		String UserName = flib.getPropertyKeyValue("un");
		String PassWd = flib.getPropertyKeyValue("pw");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWd);
		driver.findElement(By.id("submitButton")).click();
		
		//product data
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Random ran =new Random();
		int RanNum = ran.nextInt(1000);
		
		FileInputStream fis=new FileInputStream("./Book2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet pro = book.getSheet("product");
		Row row = pro.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue()+RanNum;
		
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Navigate to Campaign
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//fill data from excel Campaign
		FileInputStream fis2=new FileInputStream("./Book2.xlsx");
		Workbook book1 = WorkbookFactory.create(fis2);
		Sheet sheet1 = book1.getSheet("campaign");
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.getCell(0);
		String data1 = cell1.getStringCellValue()+RanNum;		
		driver.findElement(By.name("campaignname")).sendKeys(data1);
		
		//click add button of product
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//swithing window
		Set<String> llID = driver.getWindowHandles();
		Iterator<String> it = llID.iterator();
		while(it.hasNext())
		{
		String wid = it.next();
		driver.switchTo().window(wid);
		if(driver.getTitle().contains("Products&action"))
		{
		break;
		}
		}
		driver.findElement(By.id("search_txt")).sendKeys(data) ;
		driver.findElement(By.name("search")).click();
		
		
		//Dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
		
		//switching back
		Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> it1=allId1.iterator();
		while(it1.hasNext())
		{
		String wid = it1.next();
		driver.switchTo().window(wid);
		if(driver.getTitle().contains("Campaigns&action"))
		{
		break;
		}}
driver.findElement(By.xpath("//input[contains(@class,'crmButton small save')]")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();
		
	}
	public int add() {
		int a=10;
		int b=20;
		int c=a+b;
		return c;
	}

}