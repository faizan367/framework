package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.jenericutility.BaseClass;

import junit.framework.Assert;
@Listeners(com.crm.jenericutility.ListionerImplemention.class)
public class sampleTest extends BaseClass{
	@Test
	public void verifyHomePage() {
		System.out.print("test start");	
		String expectedTitle="home".trim();
		System.out.print("capture page title");
		String actTitle=driver.getTitle().trim();
		Assert.assertEquals("actTitle",expectedTitle);
		System.out.print("test end");	
			
		}
	@Test
	public void verifyLogoHomePage() {
		System.out.print("test start");	
		System.out.print("capture page logo");
		boolean actStats=driver.findElement(By.xpath(".//img[@title='vtiger-crm-logo.gif']")) != null;
		Assert.assertTrue(actStats);
		System.out.print("test end");	
			
		}
	
}
