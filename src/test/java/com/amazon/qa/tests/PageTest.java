package com.amazon.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LinkPage;
import com.amazon.qa.pages.SignUp;

public class PageTest extends TestBase {
	
	
	SignUp signLogin;
	LinkPage nextPage;
	

	public PageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub	
	}
	@BeforeMethod
	public void setUP() throws IOException, InterruptedException {
		initialization(); 
		signLogin = new SignUp();
		
		
	}
	
	@Test(priority = 1)
	public void pageTitle() {
		String title = signLogin.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test(priority = 2)
	public void loginTest() throws IOException, InterruptedException {
		nextPage = signLogin.login(prop.getProperty("username"), prop.getProperty("password")); 
		 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
