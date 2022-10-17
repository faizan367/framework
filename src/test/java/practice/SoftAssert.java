package practice;

import org.testng.annotations.Test;

import junit.framework.Assert;
@Test
public class SoftAssert {
	public void createCustomerTest() {
		System.out.print("step1");	
		System.out.print("step2");
		SoftAssert s=new SoftAssert();
		s.assertEquals("A","B");
		System.out.print("step3");
		s.assertEquals("X","Y");
		System.out.print("step4");	
		s.assertAll();
		}
	private void assertAll() {
		// TODO Auto-generated method stub
		
	}
	private void assertEquals(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void modifyCustomerTest() {
		System.out.print("step1");	
		System.out.print("step2");
		Assert.assertEquals("A","B");
		System.out.print("step3");	
		System.out.print("step4");	
		}

}
