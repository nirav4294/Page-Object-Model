package com.amazon.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LinkPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SignUp;

public class LoginPageTest extends TestBase {
	

	SignUp signLogin;
	LinkPage nextPage;
	LoginPage loginPage;

	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUP() throws IOException, InterruptedException {
		initialization(); 
		signLogin = new SignUp();
		loginPage = new LoginPage();
		nextPage = signLogin.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage = nextPage.clickFreeAcc();
		
}
	
	@Test(priority = 1)
	public void planDisplayVerifyTest() {
		Assert.assertTrue(loginPage.planDisplay(), "plan header is missing");
		
		
		
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
