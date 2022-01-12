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

public class LinkPageTest extends TestBase{
	

	SignUp signLogin;
	LinkPage nextPage;
	LoginPage loginPage;

	public LinkPageTest() throws IOException {
	super();	
	}

	@BeforeMethod
	public void setUP() throws IOException, InterruptedException {
		initialization(); 
		signLogin = new SignUp();
		nextPage = signLogin.login(prop.getProperty("username"), prop.getProperty("password"));
		

}
	@Test(priority = 1)
	public void afterLoginTitle() {
	String LinkPageTitle = 	nextPage.homePageTitle();
	Assert.assertEquals(LinkPageTitle, "Cogmento CRM","Link Page Title not matched");
	}
	@Test(priority = 2)
	public void verifyUsername() {
		boolean b= nextPage.verifyUsername();
		Assert.assertTrue(b, "verified");
	}
	
	@Test(priority = 3)
	public void enterName() {
		nextPage.searchbox();
	}
	
	@Test(priority = 3)
	public void clickOnAcc() throws IOException {
		loginPage= nextPage.clickFreeAcc();
	}
		
		

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	}
