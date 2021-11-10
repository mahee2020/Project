import java.lang.reflect.Method;
import java.sql.Driver;

import javax.swing.plaf.synth.SynthStyleFactory;

import org.databene.benerator.anno.Source;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import antlr.Utils;
import base.BaseTest;
import pages.HomePage;
import utils.App;

public class HomePageFunction extends BaseTest {

	HomePage homepage = new HomePage(driver);

	@org.testng.annotations.Test
	public void testVerifyTitle_HomePape() {
		driver.get(App.URl);
		Assert.assertEquals(driver.getTitle(), App.title);
	}

	@org.testng.annotations.Test
	public void testVerifyTabs_HomePape() {
		driver.get(App.URl);
		Assert.assertTrue(homepage.isYourFeed(), "Your feed tab is not available");
		Assert.assertTrue(homepage.isGlobalFeed(), "global feed tab is not available");
	}
	
	@org.testng.annotations.Test
	public void testVerifyHeaders_HomePape() {
		String[] headers= {"HOME","Sign in","Sign up"};
		driver.get(App.URl);
		for(String heade: headers) {
			homepage.verifyHeaders(heade);
		}
	}

	@org.testng.annotations.Test
	public void testVerifyPapularTags_HomePape() {
		driver.get(App.URl);
		int totalPapulatTag=homepage.verifyPapularTag();
		System.out.println("dd"+totalPapulatTag);
		Assert.assertEquals(totalPapulatTag, 872);
	}
   @AfterClass
   public void tearDown()
   {
	   driver.quit();
   }
}