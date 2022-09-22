package com.nopcommerceV2.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerceV2.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
	public String baseUrl=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
    public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */
		logger=logger.getLogger("nopEcommerce");
		PropertyConfigurator.configure("Log4j.properties");
		System.getProperty("user.dir");
if(br.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
else if (br.equals("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
else if (br.equals("edge")) {
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver ();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws Exception {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
		
		
	}
}
