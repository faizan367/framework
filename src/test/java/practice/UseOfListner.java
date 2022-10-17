package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.jenericutility.BaseClass;

import junit.framework.Assert;

@Listeners(com.crm.jenericutility.Listioner.class)//to take fail test case screenshot
public class UseOfListner extends BaseClass{
@Test
	public void  aaa()throws Throwable {
		System.out.print("test start");	
		Assert.assertEquals(false,true);
		System.out.print("test end");	

	}

}
