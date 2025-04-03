package testBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testdata {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		
		driver=new ChromeDriver();
		driver.get("https://app.fireflink.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@Test(priority=1,dataProvider="inputs")
	public void luanch(String emails) {
		
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(emails);
		 
	}
	
	
	@DataProvider(name="inputs")
	public Object[][] inputs(){
		
		Object[][]inputdata= {
				
				{"a"},{"b"}
		};
		
		return inputdata;
		
		
	} 
	

	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	

}
