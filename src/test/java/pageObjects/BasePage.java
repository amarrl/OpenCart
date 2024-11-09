package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


//Create Base Page under 'pageobject class' which includes only constructor this will be invoked by everypageobject classe constructor (reusability)
public class BasePage {
	public WebDriver driver;
	
	BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
