package com.crm.ObjectReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaign {
	  //intialisation
	   public  CreateCampaign(WebDriver driver) {
	      PageFactory.initElements(driver, this);
	    }
	  //declarationtion
	  @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	  private WebElement PlusSignForCampain;

	  @FindBy(name="campaignname")
	  private WebElement CampainTextField;

	  @FindBy(xpath="//input[@accesskey='S']")
	  private WebElement campainSubmitbutton;
	  
	  
	//gettermethods

	  public WebElement getPlusSignForCampain() {
	    return PlusSignForCampain;
	  }

	  public WebElement getCampainTextField() {
	    return CampainTextField;
	  }

	  public WebElement getCampainSubmitbutton() {
	    return campainSubmitbutton;
	  }
	  
	  /**
	   * Bussiness login
	   * @param AcountName
	   */
	public void CampainNotSubmittButton(String AcountName) {
	    
	  PlusSignForCampain.click();
	  CampainTextField.sendKeys(AcountName);
	  
	  
	     }
	public void CampainWithSubmittButton(String AcountName) {
	  
	  PlusSignForCampain.click();
	  CampainTextField.sendKeys(AcountName);
	  campainSubmitbutton.click();
	  
	     }

	}