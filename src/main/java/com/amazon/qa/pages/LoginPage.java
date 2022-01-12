package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath= "//div[contains(text(),'Your Current Plan')]")
	WebElement plan;
	
	@FindBy(xpath= "//a[contains(text(),'Configuration')]")
	WebElement configLink;
	
	
	
	
	
	 public LoginPage() throws IOException {
	 
	 PageFactory.initElements(driver, this);
	 
	 
	 }
	 
	 public boolean planDisplay() {
		return plan.isDisplayed();
	 }
	 
	 public boolean linkConfig() {
		return configLink.isDisplayed();
	 }
	
	
	
	

}
