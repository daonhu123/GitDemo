package org.rahulshettyacademy.pageObjects.android;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FormPage extends AndroidActions {
	AndroidDriver driver;
	
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;		
	//	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);//	
		}	
	
			
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nhu");
	
	@FindBy(xpath="//*[@text='Female']")  ////android.widget.RadioButton
	private WebElement femaleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	
	@FindBy(xpath="//*[@text='Male']")
	private WebElement maleOption;
	
	
	@FindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		//driver.hideKeyboard();
	}
	
	public void setCountrySelection(String countryName) throws InterruptedException {
		countrySelection.click();
		ScrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public void setGender(String gender) {
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
		
	public ProductCatalogue submitForm() {
		shopButton.click();
		return new ProductCatalogue(driver);
		
	}
	
}

