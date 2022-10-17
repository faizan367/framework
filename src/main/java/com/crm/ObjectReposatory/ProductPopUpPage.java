package com.crm.ObjectReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPopUpPage {
	
	//Initialization
	public ProductPopUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchNowButton;
	
	
	
//Getter Methods
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	//business logic
	public void searchProductLink(String prodName)
	{
		searchTextField.sendKeys(prodName);
		searchNowButton.click();
	}
	
	//Note :-->  we can't write Dynamic xpath in POM class
	
	
}