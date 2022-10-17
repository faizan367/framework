package com.crm.ObjectReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	  //intialisation
	  public  HomePage(WebDriver driver) {
	  PageFactory.initElements(driver, this);      }
	  
	//Intialisation
	@FindBy(linkText="Organizations") 
	private WebElement link_Organizations_HomePage;

	@FindBy(linkText="Products") 
	private WebElement link_Products_HomePage;

	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement Campainlink_HomePage;

	@FindBy(xpath="//a[@href='javascript:;']") 
	WebElement Link_More_HomePage;


	@FindBy(xpath="//td[@valign='bottom']/..//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLink_HomePage;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Logoutbutton_HomePage;


	//Getter Methods
	  
	public WebElement getLink_Products() {
	  return link_Products_HomePage;
	}

	public WebElement getCampainlink() {
	  return Campainlink_HomePage;
	}
	public WebElement getLink_Organizations_HomePage() {
	  return link_Organizations_HomePage;
	}

	public WebElement getLink_More_HomePage() {
	  return Link_More_HomePage;
	}

	public WebElement getOrganisationLogingout() {
	  return AdministratorLink_HomePage;
	}

	public WebElement getOrganisationLogoutbutton() {
	  return Logoutbutton_HomePage;
	}

	/**
	 * Bussiness logic for home Page
	 * @throws Throwable
	 */

	public void OrganisationLinkInHome() throws Throwable {
	  link_Organizations_HomePage.click();   }


	public void product_inHomePageMethod() {
	  link_Products_HomePage.click();   }

	public void MoreLimk_HomePage(WebDriver driver) {
	  Actions action =new Actions(driver);
	  action.moveToElement(Link_More_HomePage).perform();  }

	public void CampainLink_inHomepageMetod(){
	  Campainlink_HomePage.click();
	}
	public void  AdministrationInHomePage(){
	  AdministratorLink_HomePage.click();
	}
	public void LogOutButton(){
	  Logoutbutton_HomePage.click();
	}


	}