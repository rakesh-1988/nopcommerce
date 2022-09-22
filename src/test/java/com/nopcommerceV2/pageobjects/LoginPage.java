package com.nopcommerceV2.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPwd;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")  
	@CacheLookup
	WebElement lnklogout;
	
	
	
	public void setUsername(String uname) {
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		Actions act=new Actions(ldriver);
				
		act.moveToElement(lnklogout).click().build().perform();
		
	}
	public void setclear() {
		txtEmail.clear();
		txtPwd.clear();
		
	}
}
