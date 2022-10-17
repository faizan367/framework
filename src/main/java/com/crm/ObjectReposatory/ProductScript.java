package com.crm.ObjectReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductScript {
	  
	//intialisation
	     public ProductScript(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	      }
	     
	//Declaration
	     
	  @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	  private WebElement PlusSingnForOroduct;

	  @FindBy(xpath="//input[@name='productname']")
	  private WebElement ProsductTestField;

	  @FindBy(xpath="//input[@accesskey='S']")
	  private WebElement ProductSubmitbutton;
	  
	  @FindBy(id="32")
	  private WebElement SelectProduct;
	  
	  @FindBy(xpath="//input[@value='Delete']")
	  private WebElement DeletProductbutton;
	    
	  
	  






	//Getter methods
	   public WebElement getPlusSingnForOroduct() {
	    return PlusSingnForOroduct;
	  }

	  public WebElement getProsductTestField() {
	    return ProsductTestField;
	  }

	  public WebElement getProductSubmitbutton() {
	    return ProductSubmitbutton;
	  }
	  
	  public WebElement getDeletProductbutton() {
	    return DeletProductbutton;
	  }
	    public WebElement getSelectProduct() {
	    return SelectProduct;
	  }
	  /**
	   * Bussines logic
	   * @param AcountName
	   */
	  
	  public void product(String AcountName) {
	    
	    PlusSingnForOroduct.click();
	    ProsductTestField.sendKeys(AcountName);
	    ProductSubmitbutton.click();
	    
	     }
	public void Deleteproduct() {
	  SelectProduct.click();
	  DeletProductbutton.click();
	    
	    
	     }
	}