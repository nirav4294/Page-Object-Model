package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\Selenium_WorkSpace\\MavenProject04\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(f);	
	}

public static void initialization() throws InterruptedException {
	
	String browser = prop.getProperty("browser");
	
	if(browser.equals("ff")) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
	}else if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver1.exe");
		driver = new ChromeDriver();
		
	}
	/*
	 * <listeners>
<listener class-name = "com.amazon.qa.ExtentReportListener.ExtentReportListener"/>
</listeners>
	 * 
	 * 
	 * 
	 */
	
	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	//Thread.sleep(3000);
	
}

}
