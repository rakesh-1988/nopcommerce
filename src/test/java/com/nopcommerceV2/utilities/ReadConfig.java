package com.nopcommerceV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;

public ReadConfig() {
	
	File src=new File("./configuration//configuration.properties");
	
	try {
		
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		
	} catch (Exception e) {
		System.out.println("Exception is"+e.getMessage());
		
	}
	
	
}
public String getApplicationURL() {
	String url=pro.getProperty("baseUrl");
	return url;
}
public String getUseremail() {
	String username=pro.getProperty("username");
	return username ;
}
public String getPassword() {
	String password=pro.getProperty("password"); 
	return password;
}
/*
 * public String getChromePath() { String
 * chromepath=pro.getProperty("chromepath"); return chromepath; } public String
 * getIEPath() { String IEPath=pro.getProperty("iepath"); return IEPath; }
 * public String getFirefoxPath() { String
 * firefoxPath=pro.getProperty("firefox"); return firefoxPath ; }
 */
}