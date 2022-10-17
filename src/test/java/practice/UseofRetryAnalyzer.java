package practice;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.jenericutility.BaseClass;

import junit.framework.Assert;

public class UseofRetryAnalyzer extends BaseClass {
	@Test(retryAnalyzer=com.crm.jenericutility.RetryAnalyser.class)//to run the fail test cases again
	public void amazonTest() throws IOException{
		Assert.assertEquals("A","B");

	}

}
