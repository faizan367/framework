package practice;

import org.testng.annotations.Test;

import junit.framework.Assert;


public class HardAssertdemo {
	@Test
public void createCustomerTest() {
System.out.print("step1");	
System.out.print("step2");
Assert.assertEquals("A","B");
System.out.print("step3");	
System.out.print("step4");	
}

@Test
public void modifyCustomerTest() {
System.out.print("step1");	
System.out.print("step2");
System.out.print("step3");	
System.out.print("step4");	
}
}
