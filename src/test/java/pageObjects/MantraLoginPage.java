package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MantraLoginPage extends BasePage {
	
	public MantraLoginPage(WebDriver driver){
		
		super(driver);
	}
	
	@FindBy (id="mobileNumberPass") private WebElement emailTextField;
	@FindBy (xpath="//input[@autocomplete='new-password' and @class='form-control has-feedback']") private WebElement passwordField;
	
	@FindBy (xpath="//button[text()='LOGIN']") WebElement loginButton;
	
	
	public void setEmail(String emaiId) {
		this.emailTextField.sendKeys(emaiId);	
		
	}
	

	public void setPassword(String password) {
		passwordField.sendKeys(password);	
		
	}
	
	public void Login(String emailId,String password) {
		setEmail(emailId);
		setPassword(password);
		loginButton.click();
	}
	
	

}
