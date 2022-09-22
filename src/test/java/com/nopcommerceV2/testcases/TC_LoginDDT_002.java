package com.nopcommerceV2.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerceV2.pageobjects.LoginPage;
import com.nopcommerceV2.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws Exception {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		logger.info("webpage is opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.setclear();
		
		
		lp.setUsername(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickLogin();
		logger.info("admin page is opened");
		
		Thread.sleep(5000);

		
		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")){
			
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("test is passed");
			
			
		}else {
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info(" test is failed");
			
		}
		
		
			}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopCommerceV2/testdata/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for (int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
}
