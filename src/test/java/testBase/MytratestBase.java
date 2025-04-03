package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.MantraLoginPage;

public class MytratestBase {
	
	
	public WebDriver driver;
	

	@BeforeClass
	public void setUp(){
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.myntra.com/login/password");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
