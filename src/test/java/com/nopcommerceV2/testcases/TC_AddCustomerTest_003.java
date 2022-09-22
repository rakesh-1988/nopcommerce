package com.nopcommerceV2.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerceV2.pageobjects.AddCustomerPage;
import com.nopcommerceV2.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws Exception {
		
		driver.get(baseUrl);
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("pwd is provided");
		lp.clickLogin();
		logger.info("page is clicked");
		
		AddCustomerPage addcust=new AddCustomerPage();
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();
		
		String email=randomestring()+ "@gmail.com";
		addcust.clickOnAddnew();
		addcust.setEmail(email);
		addcust.setPassword("test123"); 
		
		addcust.setCustomerRoles("Guest");
		addcust.setGender("Male");
		addcust.setFirstName("Rakesh");
		addcust.setLastName("Tumbal");
		addcust.setDob("31/05/1988");
		addcust.setCompanyName("TCS");
		addcust.setAdminContent("This is for testing");
		addcust.clickOnSave();
		logger.info("validation started");
		
		String msg=driver.findElement(By.tagName("body")).getText();
		
		if(msg.contains("The new customer has been added successfully")) {
			
			Assert.assertTrue(true);
			logger.info("test case passed");
			
		}
		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
public static String randomestring() {
	String generatedString1=RandomStringUtils.randomAlphabetic(5);
	return(generatedString1);
}
public static String randomeNum() {
	String generatedString2=RandomStringUtils.randomNumeric(4);
	return(generatedString2);
	
}
}
