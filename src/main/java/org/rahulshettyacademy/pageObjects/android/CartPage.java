package org.rahulshettyacademy.pageObjects.android;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.utils.AndroidActions;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CartPage extends AndroidActions{
	AndroidDriver driver;
	String total;
	Double actualTotal;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> listPrice;
	
	@FindBy(xpath="//android.widget.TextView[@text='Please read our terms of conditions']")	
	public WebElement terms;
	
	@FindBy(id="android:id/button1")
	public WebElement okBtn;
	
	@FindBy(xpath="//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
	public WebElement checkbox;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement submitBtn;
	
	@FindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public WebElement title;
	
	
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;		
	//	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);//	
		waitForElementToAppear(title,driver);
		}	
	
	
	public Double actualResult() {
		total = totalAmount.getText();
		return this.getFormattedAmount(total);
		
	}
	
	public double expectedResult() {
		double expectedTotal = 0;
		for(int i=0; i<listPrice.size(); i++) {
			String priceString = listPrice.get(i).getText();
			Double price = getFormattedAmount(priceString);
			expectedTotal = expectedTotal + price ;
			
		}
		return expectedTotal;
	}
	
	
		
    public void acceptTermsCondition() {
	//	LongPressAction(terms);		
		okBtn.click();	
				
	}
	
	public void submitOrder() { 
		checkbox.click();
		submitBtn.click();
		
	}
}
