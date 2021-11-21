package com.assignment.test;

import org.testng.annotations.Test;

import com.assignment.pages.Objects_FBhomepage;
import com.assignment.pages.Objects_FBloginpage;

public class LoginFacebook extends Baseclass {

	@Test
	public void loginFb() throws InterruptedException {
		Objects_FBloginpage lp = new Objects_FBloginpage(driver);
		Objects_FBhomepage hp = new Objects_FBhomepage(driver);

		lp.launchFacebook();
		log.info("Launched FaceBook");
		lp.login();
		log.info("Logged into FaceBook");
		hp.postStatus();
		log.info("Posted the status");
	}

}
