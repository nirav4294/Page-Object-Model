package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LinkPage extends TestBase{
	
	
	@FindBy(xpath = "//a[contains(text(),'Free account')]")
	WebElement freeAcc;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchTab;
	
	@FindBy(xpath = "//div[@class='header item']")
	WebElement logo;
	
	@FindBy(className = "user-display")
	WebElement UserDisplay;
	
	
	public LinkPage() throws IOException {
		
		PageFactory.initElements(driver	, this);
		
	
	}
	public String homePageTitle() {
		return driver.getTitle();
	}
	public LoginPage clickFreeAcc() throws IOException {
		freeAcc.click();
		return new LoginPage();
	}
	public void searchbox() {
		searchTab.sendKeys("Nirav"); 
	}
	public boolean verifyUsername() {
		return UserDisplay.isDisplayed();
		
	}

}
