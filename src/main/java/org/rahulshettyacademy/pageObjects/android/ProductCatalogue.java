package org.rahulshettyacademy.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ProductCatalogue extends AndroidActions{
	AndroidDriver driver;
	
	@FindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> addToCart;
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartBtn;
	
	
	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;		
	//	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(driver, this);//	
		}	
	
	
	public void addItemToCartByIndex(int n) {
		addToCart.get(n).click();
	}
	
	public CartPage goToCartPage() throws InterruptedException  {
		cartBtn.click();
		Thread.sleep(4000);
		return new CartPage(driver);
	}
		
}
