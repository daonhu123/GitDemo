package org.rahulshettyacademy.TestUtils;

import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.android.Activity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.pageObjects.android.FormPage;
import org.rahulshettyacademy.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	
	
	@BeforeClass(alwaysRun = true)
	public void ConfigAppium() throws IOException 
	{	
		//Read data configure from data.properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//rahulshettyacademy//resources//data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String devicename = prop.getProperty("AndroidDeviceName");
				
				
		//Start Server
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		
		//AndroidDriver, IOSDriver
		//Connect Device And Open App	
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(devicename);
		options.setChromedriverExecutable("C://Users//ty338158//Documents//chromedriver_83.0.4103//chromedriver.exe");
		//options.setApp("C://Users//ty338158//eclipse-workspace_new//AppiumFrameworkDesign//src//test//java//resources//ApiDemos-debug.apk");	
		options.setApp(System.getProperty("user.dir")+ "//src//test//java//resources//General-Store.apk");	
		driver = new AndroidDriver(service.getUrl(), options);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
		
	}
	
		
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		//Quit App
		driver.quit();		
		//Stop Server
		service.stop();
		
	}

}
