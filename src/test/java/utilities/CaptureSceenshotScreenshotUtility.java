package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureSceenshotScreenshotUtility {
	public static void captureScreenshot(WebDriver driver,String testName) {
		
		File fi=new File("C:\\New folder");
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		
		File output=tc.getScreenshotAs(OutputType.FILE);
		
		output.renameTo(fi);
		
		
	}

}
