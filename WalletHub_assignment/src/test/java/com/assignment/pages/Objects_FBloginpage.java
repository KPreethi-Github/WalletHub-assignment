package com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Objects_FBloginpage {

	String url = "https://www.facebook.com/";
	String username = "preetee22@gmail.com";
	String password = "cindrella";

	WebDriver ldriver;

	public Objects_FBloginpage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public By uname = By.id("email");
	public By pwd = By.id("pass");
	public By loginbtn = By.name("login");

	public void launchFacebook() {
		ldriver.get(url);
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(uname));
	}

	public void login() {
		ldriver.findElement(uname).sendKeys(username);
		ldriver.findElement(pwd).sendKeys(password);
		ldriver.findElement(loginbtn).click();
	}

}
