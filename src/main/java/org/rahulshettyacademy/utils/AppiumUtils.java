package org.rahulshettyacademy.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import com.fasterxml.jackson.core.type.*;


public abstract class AppiumUtils {
	public AppiumDriverLocalService service;
	
	public Double getFormattedAmount(String str) {
		Double price = Double.parseDouble(str.substring(1));
		return price;
		
	}
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{
		//conver json file content to json string
		
		//System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json"
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		//Start Server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//ty338158//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;		
	}
	
	
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.attributeContains((ele),"text", "Cart"));
				
	}	
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException 
	{
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+ "//reports"+ testCaseName + ".png";
		FileUtils.copyFile(source, new File (destinationFile));
		return destinationFile;
		//1. capture and place in folder //2. extend report pick file and attach to report
	}

}
