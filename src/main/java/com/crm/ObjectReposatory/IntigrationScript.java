package com.crm.ObjectReposatory;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IntigrationScript {
	  

	   
	  //intialisation
	   public IntigrationScript(WebDriver driver) {
	      PageFactory.initElements(driver, this);
	    }
	   
	  //Dleclaration
	   @FindBy(linkText="ndt1")
	   private WebElement ProductAccountlinkIn_Intigartion;

	   @FindBy(xpath="//input[@class='crmbutton small save']")
	   private WebElement SaveButtonFor_Intigration;
	  
	   @FindBy(xpath="//img[@src='themes/softed/images/select.gif']") 
	   WebElement PLUSSIGNInCampain_Intigration;
	  
	   //Getter methods
	   public WebElement getPLUSSIGNInCampain_Intigration() {
	    return PLUSSIGNInCampain_Intigration;
	  }

	  public WebElement getProductAccountlinkIn_Intigartion() {
	    return ProductAccountlinkIn_Intigartion;
	  }

	  public WebElement getSaveButtonFor_Intigration() {
	    return SaveButtonFor_Intigration;
	  }
	  public void Intigration(WebDriver driver,String AccountName) throws Throwable {
	  
	    PLUSSIGNInCampain_Intigration.click();
	    
	    Set<String> windowids = driver.getWindowHandles();
	      Iterator <String> stovered=windowids.iterator();
	      String parentwindow=stovered.next();
	      String childwindow=stovered.next();
	      driver.switchTo().window(childwindow);
	      
	      ProductAccountlinkIn_Intigartion.click();
	      driver.switchTo().window(parentwindow);   
	      SaveButtonFor_Intigration.click();
	  }
}