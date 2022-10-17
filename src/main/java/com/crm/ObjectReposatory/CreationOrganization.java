package com.crm.ObjectReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreationOrganization {
	  //intialisation
	   public CreationOrganization(WebDriver driver) {
	      PageFactory.initElements(driver, this);
	    }
	   
	   //Declaration
	  
	  @FindBy(xpath="//img[@title='Create Organization...']")
	  private WebElement PlusSingnForOrganisation;
	  
	  @FindBy(xpath="//input[@name='accountname']")
	  private WebElement OrganisationTestField;
	  
	  @FindBy(xpath="//input[@accesskey='S']")
	  private WebElement OrganisationSubmitbutton;
	  
	  
	  
	  
	  public WebElement getPlusSingnForOrganisation() {
	    return PlusSingnForOrganisation;
	  }

	  public WebElement getOrganisationTestField() {
	    return OrganisationTestField;
	  }

	  public WebElement getOrganisationSubmitbutton() {
	    return OrganisationSubmitbutton;
	  }

	  
	  /**
	   * bussiness use
	   * @param Accountname
	   * @throws Throwable
	   */
	  public void Organisation(String Accountname) throws Throwable {
	    
	    PlusSingnForOrganisation.click();
	    OrganisationTestField.sendKeys(Accountname);
	    OrganisationSubmitbutton.click();
	    Thread.sleep(5000);
	    
	    }

	}