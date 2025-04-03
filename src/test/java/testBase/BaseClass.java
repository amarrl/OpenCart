package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;





//reusbale methods
public class BaseClass {
	public Properties p;
	public WebDriver driver;
	public Logger logger;  //Log4j
	
	@BeforeClass
	@Parameters({"os","browser"}) 
	public void setUp(String os,String br) throws IOException {
		
		FileInputStream fi=new FileInputStream("C:\\Users\\Amar\\eclipse-workspace\\new 2024 ide\\Opencart\\src\\test\\resources\\config.properties");
		 p=new Properties();
			p.load(fi);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_envirnment").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			
		//os and browser
			if(os.equalsIgnoreCase("windows")) {  
				
			cap.setPlatform(Platform.WIN11);
			
		}
			
			else if(os.equalsIgnoreCase("mac")) {
				
				cap.setPlatform(Platform.MAC);
				
			}
			
			else {
				System.out.println("no matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase()) {
			case  "chrome":cap.setBrowserName("chrome");break;
			case  "edge":cap.setBrowserName("MicrosoftEdge");break;
default:System.out.println("no matching browser");return;
			}
			
			
			driver=new RemoteWebDriver(new URL("http://192.168.178.238:4444/wd/hub"),cap);
		}
		
	
		
		if(p.getProperty("execution_envirnment").equalsIgnoreCase("local")) {

			switch(br.toLowerCase()) {
			case "chrome":	driver=new ChromeDriver(); break;
			}
		
		}
	
		String navguideurl=p.getProperty("appURL");
		
		

		
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
