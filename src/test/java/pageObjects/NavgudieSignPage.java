package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavgudieSignPage extends BasePage {
	
	public NavgudieSignPage(WebDriver driver) {
		super(driver);  //instead of writering pageFactory.initelements every time we created this
	}
	
	@FindBy(xpath="//div[@class='form-group']//child::input[@id='LoginName']")WebElement email;
	
	@FindBy (xpath="//div[@class='form-group']//child::input[@id='Password']")WebElement password;
	
	@FindBy (xpath="//div[@class='form-group']//child::input[@name='RememberMe']")WebElement RemeberMe;
	
	@FindBy (xpath="//h4[text()='Sign in your account']") WebElement textsignPagetext;
	
	@FindBy(xpath="//button[text()='Login']") WebElement buttLogin;
	
	  
	
	
	
	
	public void enterInput(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void remeberme() {
		RemeberMe.click();
	}
	
	public String getTextsignpage() {
		try {
		return(textsignPagetext.getText());
		}catch(Exception e){
			return e.getMessage();
		}
		}
	
	
	}
		


