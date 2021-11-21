package com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Objects_FBhomepage {

	WebDriver ldriver;

	public Objects_FBhomepage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public By statusTxtbox = By.xpath("//span[contains(text(),\"What's on your mind, \")]");
	public By postTxtbox = By.xpath("//div[@class='_1mf _1mj']");
	public By postbtn = By.xpath("//span[text()='Post']");
	String message = "Hello World";

	public void postStatus() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(statusTxtbox));
		ldriver.findElement(statusTxtbox).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(postTxtbox));

//				ExpectedConditions.alertIsPresent() ;
		/*
		 * if(wait.until(ExpectedConditions.alertIsPresent())==null)
		 * System.out.println("Alert not exists"); else
		 * System.out.println("Alert exists");
		 */
		/*
		 * // Check the presence of alert Alert alert = ldriver.switchTo().alert(); //
		 * Alert present; set the flag Boolean presentFlag = true; // if present consume
		 * the alert alert.dismiss();
		 * 
		 * //( Now, click on ok or cancel button )
		 * 
		 * } catch (NoAlertPresentException ex) { // Alert not present
		 * ex.printStackTrace(); }
		 */
		/*
		 * Set<String> allWindowHandles = ldriver.getWindowHandles(); ArrayList<String>
		 * tabs = new ArrayList<String>(allWindowHandles); S
		 * System.out.println("No. of tabs: " + tabs.size());
		 */
		/*
		 * Robot robot; try { robot = new Robot(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(200); } catch (AWTException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */


		ldriver.findElement(postTxtbox).sendKeys(message);
		ldriver.findElement(postbtn).click();
	}

}
