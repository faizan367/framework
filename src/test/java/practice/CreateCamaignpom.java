package practice;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectReposatory.CreateCampaign;
import com.crm.ObjectReposatory.HomePage;
import com.crm.ObjectReposatory.LoginPage;
import com.crm.jenericutility.Excel_utility;
import com.crm.jenericutility.File_utility;
import com.crm.jenericutility.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateCamaignpom {

  public static void main(String[] args) throws Throwable {
    
  /*  String path="./Book1.xlsx";

    FileInputStream fis=new FileInputStream(path);
    Workbook book = WorkbookFactory.create(fis);

    String KEY      = book.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
    String VALUE    = book.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
    String URL      = book.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
    String USERNAME = book.getSheet("Sheet1").getRow(2).getCell(3).getStringCellValue();
    String PASSWORD = book.getSheet("Sheet1").getRow(2).getCell(4).getStringCellValue();
    String data     = book.getSheet("Sheet1").getRow(2).getCell(5).getStringCellValue();

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
          driver.findElement(By.name("campaignname")).sendKeys("data");
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
      Webdriver_utility  weu=new Webdriver_utility();   
     
       
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
        // String PASSWORD=xlu.getExelKeyValue("sheet1", 1, 4);
        //  String data=xlu.getExelKeyValue("sheet1", 1, 5);  
    
      //maximizing window
      weu.maximizebrowser(driver);
      
      //implicitly wait
      weu.implicittWait(driver);
      //Login Page
       driver.get(URL);
       LoginPage login=new LoginPage(driver);
       login.login(uSERnAME, PassWord);      
      
       //HOMEpage
      HomePage hp2=new HomePage(driver); 
      
      hp2.MoreLimk_HomePage(driver);
        hp2.CampainLink_inHomepageMetod();
        
        CreateCampaign cs=new CreateCampaign(driver);
      cs.CampainWithSubmittButton("jjf3");
      
      hp2.AdministrationInHomePage();
      hp2.LogOutButton();
             driver.quit();
         

  }

}

