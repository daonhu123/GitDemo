package org.rahulshettyacademy;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.*;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class eCommerce_tc_2 extends AndroidBaseTest{
	
	
	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void preSetup(){
		//screen to home page
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);	// stuck 2
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).clear();
//		Thread.sleep(3000);
//	    ConfigAppium();
		//abc 123
	    
	}
	
	
	@Test
	public void FillForm_ErrorValidation()  {		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nhu");	
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastmessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getText();
		Assert.assertEquals(toastmessage, "Please enter your name");
				
	}
		
	
	@Test
	public void FillForm_PositiveFlow() {
		//waitForElementToAppear(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), driver);
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nhu");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//String toastmessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getText();
		Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast[1]")).size()<1);
				
	}
	
}
