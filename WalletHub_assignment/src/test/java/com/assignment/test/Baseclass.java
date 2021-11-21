package com.assignment.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	public static WebDriver driver;
	public static Logger log;

	@BeforeMethod
	public void setup() throws InterruptedException {
		log = Logger.getLogger("Assignment-Log");
		PropertyConfigurator.configure("Log4j.properties");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Launched Browser");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		log.info("Closed Browser\n");
	}

}
