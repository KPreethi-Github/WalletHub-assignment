package com.assignment.test;

import org.testng.annotations.Test;

import com.assignment.pages.Objects_WalletHub_Homepage;
import com.assignment.pages.Objects_WalletHub_Reviewpage;

public class ReviewWalletHub extends Baseclass {

	@Test

	public void loginToreview() throws InterruptedException {
		Objects_WalletHub_Homepage hp = new Objects_WalletHub_Homepage(driver);
		Objects_WalletHub_Reviewpage rp = new Objects_WalletHub_Reviewpage(driver);

		hp.launchWalletHub();
		log.info("Launched WalletHub");
		hp.login();
		hp.gotoReview();
		rp.click4star();
		log.info("Selected 4 Star");
		rp.selectPolicy();
		log.info("Selected the policy");
		rp.writeReview();
		log.info("Submitted the review");
		rp.verifyConfirmation();
		log.info("Success message is displayed");
		rp.clickContinue();
		hp.profileReview();
		log.info("Review displaying in the Homepage");
	}

}
