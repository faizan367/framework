package com.crm.ObjectReposatory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	//Initialization
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(css="span.lvtHeaderText")
	private WebElement headerText;
	
	@FindBy(xpath="//input[@accesskey='D']")
	private WebElement deleteButton;

	//getter method
	public WebElement getHeaderText() {
		return headerText;
	}
	public WebElement getDeleteButton()
	{
		return deleteButton;
	}
	
	//business logic
	public String ValidationText() {
		String text = headerText.getText();
		return text;
		
	}
	public  void deleteProduct()
	{
		deleteButton.click();
	}

}