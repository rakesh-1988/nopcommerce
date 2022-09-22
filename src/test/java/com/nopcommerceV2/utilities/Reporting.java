package com.nopcommerceV2.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="test-report-"+timeStamp+".html";
		htmlReporter=new ExtentSparkReporter(repname);
		
			
		
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("browser","chrome");
		extent.setSystemInfo("os","Windows");
		
		htmlReporter.config().setDocumentTitle("Rakesh report");
		htmlReporter.config().setReportName("Functional report name");
	htmlReporter.config().setTheme(Theme.STANDARD);

		
		
		
	}

public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.BLUE));
		
	}

public void onTestFailure(ITestResult tr) {
	logger=extent.createTest(tr.getName());
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	String screenshotPath=new String("./Screenshot/"+ tr.getName()+ "/"+ "  .png");
	
	try {
		logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void onTestSkipped(ITestResult tr) {
	logger=extent.createTest(tr.getName());
	logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	
}

public void onFinish(ITestContext tr) {
	extent.flush();
	
}
}
