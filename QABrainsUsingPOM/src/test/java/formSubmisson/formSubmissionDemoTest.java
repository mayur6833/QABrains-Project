package formSubmisson;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClassForLogin.BaseTest;
import FormSubmission.formSubmissionDemo;

public class formSubmissionDemoTest extends BaseTest 
{
	private formSubmissionDemo obj;
	
	@BeforeClass
	public void submitAllForm()
	{
		obj = new formSubmissionDemo(driver);
	}
	
	@Test
	public void formSubmissonFunctionality() throws Exception
	{
		obj.form("ABC", "abc@gmail.com", "98767898876", "10102000");
		
		Assert.assertTrue(obj.isFormSubmittedSuccessfully(),"Form submission failed!");
	}
	
	
}
