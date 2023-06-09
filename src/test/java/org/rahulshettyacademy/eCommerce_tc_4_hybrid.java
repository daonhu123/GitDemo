package org.rahulshettyacademy;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.rahulshettyacademy.pageObjects.android.*;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;



public class eCommerce_tc_4_hybrid extends AndroidBaseTest{
	
	@Test(dataProvider="getData", groups ={"Smoke"})
	public void FillForm(HashMap<String,String> input) throws InterruptedException {	
		formPage.setCountrySelection(input.get("country"));	
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));					
		ProductCatalogue productPage = formPage.submitForm();
		productPage.addItemToCartByIndex(0);
		productPage.addItemToCartByIndex(0);
		CartPage cartPage = productPage.goToCartPage();		
		Assert.assertEquals(cartPage.expectedResult(),cartPage.actualResult());
		driver.executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"))).getId(),
						"duration", 6000));
		cartPage.acceptTermsCondition();		// stuck 1
		cartPage.submitOrder();
						
	}
	
    @SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
    public void preSetup(){
    	//ConfigAppium();
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);	
    }
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		//System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json"		
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json");		
		return new Object[][] {{data.get(0)},{data.get(1)}, {data.get(2)}};
	}
		
}
