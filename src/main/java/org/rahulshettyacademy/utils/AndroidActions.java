package org.rahulshettyacademy.utils;

import org.openqa.selenium.WebElement;



import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



public class AndroidActions extends AppiumUtils{
	public AndroidDriver driver;
	
	
	public AndroidActions(AndroidDriver driver) {
		this.driver=driver;
	}
	
	
	public void ScrollToEnd() throws InterruptedException {			
		//Scroll to end action
		boolean canScrollMore;
		do
		{canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", 100, "top", 100, "width", 200, "height", 200,
				"direction", "down", "percent", 3.0));	
		}while (canScrollMore);
		
		Thread.sleep(3000);
	} 
	
	public void ScrollToText(String text) throws InterruptedException { //\"Argentina\"
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		Thread.sleep(3000);
}
	
	public void SwipeAction(WebElement firstImage, String direction) {
	//Swipe left 
	 driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
			"elementId", ((RemoteWebElement)firstImage).getId(),
			"direction", direction,
			"percent", 0.75
	
			));
	}
	
	public void DragDropAction(WebElement source, int endX, int endY) {	
	//Drag and Drop		
	 driver.executeScript("mobile: dragGesture", ImmutableMap.of(
			"elementId", ((RemoteWebElement)source).getId(),
			"endX", endX,
			"endY", endY
			));
	
	}
	public void LongPressAction(WebElement ele)  {		
		driver.executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration", 3000));
	}	
}
