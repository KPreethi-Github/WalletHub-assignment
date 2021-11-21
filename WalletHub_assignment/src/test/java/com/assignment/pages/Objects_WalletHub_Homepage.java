package com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Objects_WalletHub_Homepage {

	WebDriver ldriver;

	public Objects_WalletHub_Homepage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	String appUrl = "http://wallethub.com/profile/test_insurance_company/";
	String profileUrl = "https://wallethub.com/profile/67737890i";

	By loginLink = By.xpath("//span[text()='Login']");
	By email = By.xpath("//input[@name='em']");
	By pwd = By.xpath("//input[@type='password']");
	By loginBtn = By.xpath("//span[text()='Login']");
	By writeReviewBtn = By.xpath("//*[@class='profile-nav-module']//button[text()='Write a Review']");
	By yourReview = By.xpath("//span[text()=' Your Review']");

	public void login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
		ldriver.findElement(loginLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		ldriver.findElement(email).sendKeys("preeteekannan@gmail.com");
		ldriver.findElement(pwd).sendKeys("Testing@123");
		ldriver.findElement(loginBtn).click();
	}

	public void launchWalletHub() {
		ldriver.get(appUrl);
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(writeReviewBtn));
	}

	public void gotoReview() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(writeReviewBtn));
		ldriver.findElement(writeReviewBtn).click();
	}

	public void profileReview() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(writeReviewBtn));
		wait.until(ExpectedConditions.visibilityOfElementLocated(yourReview));
		WebElement review = ldriver.findElement(yourReview);
		Assert.assertEquals(true, review.isDisplayed());
	}
}
