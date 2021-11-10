import java.util.Set;

import org.junit.AfterClass;
import org.testng.Assert;

import base.BaseTest;
import pages.HomePage;
import pages.SignUp;
import utils.App;
import utils.commonUtil;

public class SignUpFunction extends BaseTest {

	HomePage homepage = new HomePage(driver);
	SignUp singup = new SignUp(driver);
	commonUtil cm = new commonUtil();

	String username = commonUtil.generateRandomPassword(5);
	String emailId = commonUtil.generateRandomPassword(5);
	String password = commonUtil.generateRandomPassword(5);

	@org.testng.annotations.Test
	public void testSignUpFunction() {
		String chils = driver.getWindowHandle();
		System.out.println("chils" + chils);
		driver.get(App.URl);
		homepage.ClockOnsignUp();
		singup.signUp(username, emailId + "@gmail.com", password);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
