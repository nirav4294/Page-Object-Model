package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SignUp extends TestBase {
	

	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	public SignUp() throws IOException {
		super();
		
		
		PageFactory.initElements(driver, this);

	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public LinkPage login(String a, String b) throws IOException, InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		loginbtn.click();
		
		
		return new LinkPage();
	}

}
