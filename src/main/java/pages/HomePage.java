package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import antlr.collections.List;
import utils.WaitHelper;

public class HomePage {
	public WebDriver driver;
	WaitHelper waitHelper;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Your Feed')]")
	private WebElement yourfeed;

	@FindBy(xpath = "//a[contains(text(),'Global Feed')]")
	private WebElement globalfeed;
	
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	private WebElement signUp;
	
	
	public boolean isYourFeed() {
		boolean flag=true;
		try {
			waitHelper.waitForElementVisible(yourfeed, 10, 10 );
			flag = yourfeed.isDisplayed();
			
			return flag=true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	public boolean isGlobalFeed() {
		try {
			boolean flag;
			waitHelper.waitForElementVisible(globalfeed, 10, 10 );
			flag = globalfeed.isDisplayed();
			return flag=true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	
	public void verifyHeaders(String header) {
		try {
		WebElement s=driver.findElement(By.xpath("//a[contains(text(),'"+header+"')]"));
		Assert.assertTrue( s.isDisplayed(),"header is not present");
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
	}
	public int verifyPapularTag() {
	try {	
		int size;
    java.util.List<WebElement> tags =driver.findElements(By.xpath("//a[@class='tag-default tag-pill']"));
    size=tags.size();
    return size;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
	
	}
	public void ClockOnsignUp()
	{
		try {
			waitHelper.waitForElementVisible(signUp, 10, 10);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", signUp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}