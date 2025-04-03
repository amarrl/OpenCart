package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.NavgudieSignPage;
import testBase.BaseClass;

public class TC_001_SignIn extends BaseClass  {

	
	@Test(priority=1)

	public void VerifyLandingPage() throws InterruptedException {

		try {
		logger.info("**starting test cases***");
		NavgudieSignPage g=new NavgudieSignPage(driver);
		String signpagetxt=g.getTextsignpage();
		Thread.sleep(Duration.ofSeconds(4));
		
		System.out.println(signpagetxt);
		Assert.assertEquals(signpagetxt, "Sign in your account");
		
		String	Emai=p.getProperty("emailId");
		System.out.println(Emai);
		
		logger.info("**Entered the email id***");
		
		
	}catch(Exception e){
		logger.error("**Test failed**");
		logger.debug("debug");
		Assert.fail();
	}
	}
	 
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
	
		String email=p.getProperty("emailId");
		
		
		
		System.out.println(email);
		
		String pass=p.getProperty("password");
		NavgudieSignPage l=new NavgudieSignPage(driver);
		l.enterInput(email);
		l.enterPassword(pass);
		l.remeberme();
	
		
		Thread.sleep(Duration.ofSeconds(4));
	}
	}
	


