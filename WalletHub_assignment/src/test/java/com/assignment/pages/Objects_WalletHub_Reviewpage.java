package com.assignment.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Objects_WalletHub_Reviewpage {

	String review = "Here, it is a review about the test-scenario. Your health insurance policy provides you with financial assistance at the time of a medical emergency. Health risks and uncertainties are part of life. Hence, it is important you opt for a health insurance plan.";
	By ratingArea = By.xpath(
			"//*[text()='Test Insurance Company' and @class='wrev-prd-name']/..//div[@class='rating-box-wrapper']");
	By star4s = By.xpath(
			"//*[text()='Test Insurance Company' and @class='wrev-prd-name']/..//button[text()=' Rate 4 and review ']/preceding-sibling::*[1][local-name()='svg' ]//*[local-name()='path']");
	By policyDropdown = By.xpath("//span[text()='Select...']");
	By healthInsurance = By.xpath("//li[text()='Health Insurance']");
	By reviewArea = By.xpath("//textarea[@placeholder='Write your review...']");
	By submitBtn = By.xpath("//div[text()='Submit']");
	By successMsg = By.xpath("//*[text()='Your review has been posted.']");
	By continueBtn = By.xpath("//*[text()='Continue']");

	WebDriver ldriver;

	public Objects_WalletHub_Reviewpage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void click4star() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ratingArea));
		Thread.sleep(4000);
		WebElement ele = ldriver.findElement(star4s);

		// Creating object of an Actions class
		Actions action = new Actions(ldriver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();

		List<WebElement> star = ldriver.findElements(star4s);
		if (star.size() == 2) {
			Thread.sleep(4000);
			ldriver.findElement(star4s).click();
		}

	}

	public void selectPolicy() {
		ldriver.findElement(policyDropdown).click();
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(healthInsurance)).click();
	}

	public void writeReview() throws InterruptedException {
		ldriver.findElement(reviewArea).sendKeys(review);
		Thread.sleep(5000);
		ldriver.findElement(submitBtn).click();

	}

	public void writerandomReview() throws InterruptedException {
		char[] chars = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
//		String chars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(130);
		Random random = new Random();
		for (int i = 0; i < 130; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String review = sb.toString();
		ldriver.findElement(reviewArea).sendKeys(review);
		Thread.sleep(5000);
		ldriver.findElement(submitBtn).click();
	}

	public void verifyConfirmation() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		
		String expectedMsg = "Your review has been posted.";
		WebElement reviewMsg = ldriver.findElement(successMsg);
		Assert.assertEquals(expectedMsg, reviewMsg.getText());
	}

	public void clickContinue() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn));
		ldriver.findElement(continueBtn).click();
	}

}
