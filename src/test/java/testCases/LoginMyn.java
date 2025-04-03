package testCases;

import org.testng.annotations.Test;

import pageObjects.MantraLoginPage;
import testBase.MytratestBase;

public class LoginMyn extends MytratestBase {
	@Test(priority=1)
	public void Login() throws InterruptedException {
		MantraLoginPage login=new MantraLoginPage(driver);
		
		Thread.sleep(5000);
		
		login.Login("amar@gmail.com", "Kumar@1400");
	}

}
