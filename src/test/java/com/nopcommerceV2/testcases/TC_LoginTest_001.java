package com.nopcommerceV2.testcases;


import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.Test;
import com.nopcommerceV2.pageobjects.LoginPage;
import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	
	
	
	
	@Test
	public void loginTest() throws  Exception{
		
		driver.get(baseUrl);
		logger.info("webpage is opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.setclear();
		
		
		lp.setUsername(username);
		
		lp.setPassword(password);
		logger.info("admin page is opened");
		lp.clickLogin();
		
		
		Thread.sleep(5000);

		
		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")){
			
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("test is passed");
			
			
		}else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info(" test is failed");
			
		}
		
		 
		
	
}}
