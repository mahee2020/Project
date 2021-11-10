package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import antlr.collections.List;

public class SignUp {
	public WebDriver driver;

	public SignUp(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//app-auth-page/div/div/div/div/form/fieldset/fieldset[1]/input")
	private WebElement username;

	@FindBy(xpath = "//app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input")
	private WebElement email;
	
	@FindBy(xpath = "//app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input")
	private WebElement password;
	
	
	public void signUp( String userName ,String emailId ,String Password) {
		try {
			
			username.sendKeys(userName);
			email.sendKeys(emailId);
			password.sendKeys(Password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}
	
	
}