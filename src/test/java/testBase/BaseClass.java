package testBase;

import java.io.FileInputStream;
import java.io.FileReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


//reusbale methods
public class BaseClass {
	public Properties p;
	public WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException {
		
		FileInputStream fi=new FileInputStream("C:\\Users\\Amar\\eclipse-workspace\\new 2024 ide\\Opencart\\src\\test\\resources\\config.properties");
	 p=new Properties();
		p.load(fi);
		
		String navguideurl=p.getProperty("appURL");

		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(navguideurl);
		
		
	}
	@AfterClass
	public	void tearDown() {
		driver.close();
	}
	
	/*
	//in order to get this you need to add common lang 2 dependency in xml
	public String randomAlphabeticString() {
		String randomStsring=RandomStringUtils.randomAlphabetic(4);
		return randomStsring;
	}
	
	public String randomNumber() {
		String number=RandomStringUtils.randomNumeric(4);
		
		return number;
		
	}
	
	public String aplhaNumeric() {
		String randomStsring=RandomStringUtils.randomAlphabetic(4);
		String number=RandomStringUtils.randomNumeric(4);
		return (randomStsring+number);
	}
	
	*/



}
