package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Java_Utility;
import com.crm.jenericutility.Webdriver_utility;

public class DeleteProductHardcode {

	public static void main(String[] args) throws Throwable {
	String key="webdriver.chrome.driver";
	String value="E:\\java\\oop\\com.crm.farmework\\chromedriver.exe";
	System.setProperty(key,value);
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	File_utility fib=new File_utility();
	Excel_utility elib=new Excel_utility();
	Webdriver_utility wlib=new Webdriver_utility();
	Java_Utility jlib=new Java_Utility();

FileInputStream fis=new FileInputStream("./common.properties.txt");
Properties pro=new Properties();
pro.load(fis);
String URL = pro.getProperty("url");
String UserName = pro.getProperty("un");
String PassWord = pro.getProperty("pw");



driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(UserName);
driver.findElement(By.name("user_password")).sendKeys(PassWord);
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

FileInputStream fis1=new FileInputStream("./Book2.xlsx");

Workbook book=WorkbookFactory.create(fis1);

Sheet sh = book.getSheet("product");

Row row = sh.getRow(0);

Cell cel = row.getCell(0);

String data = cel.getStringCellValue();
driver.findElement(By.name("productname")).sendKeys(data);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

Thread.sleep(1000);

String actData = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();

if(actData.contains(data))
{
System.out.println("pass");
}
else
{
System.out.println("fail");
}
driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
wlib.switchToAlertAndDismiss(driver);
Alert alt=driver.switchTo().alert();
alt.accept();
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

}
}
	


