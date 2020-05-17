package TestPages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.IspeakBetter.Base.BasePage;
import com.lSpeakBetter.Pages.HomePage;

import ISpeakBetterUtilities.Constants;


public class HomePageTest {

	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homepage;
	
	
	@BeforeMethod
	public void SetUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homepage = new HomePage(driver);
	}
	
	@Test (priority=1, description="Title")
	public void getTitleHomePage(){
	String title =	homepage.getHomePageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Constants.ISPEAKBETTERHOMEPAGETITLE);
	}
	
	@Test (priority = 2, description = "Header")
	public void getHeader() throws InterruptedException{
	String header = homepage.getHeader();	
	System.out.println(header);
	Assert.assertEquals(header, Constants.HOMEPAGEHEADER);
	}
	@Test (priority=3, description = "GooglePlayerisDisplayed")
	public void verifyingGooglePlayer() throws InterruptedException{
		homepage.verifyGooglePlayer();
	}
	
	@Test (priority =4,description= "ApplePlayerisDisplayed")
	public void applePlayer() throws InterruptedException{
		homepage.verifyAppStore();
		
	}
	

	@Test (priority =5, description = "Select Language")
	public void selectLanguage() throws InterruptedException{
		Thread.sleep(2000);

		String TurkishTitle = homepage.selectLanguage();
		System.out.println(TurkishTitle);
		Assert.assertEquals(TurkishTitle, Constants.TURKISHPAGETITLE);
		driver.navigate().back();
		Thread.sleep(2000);
	}
	
	@Test (priority = 6, description = "ChatBox")
	public void chatBox() throws InterruptedException{
	homepage.chatBox();
	}
	
	@Test (priority = 7, description = "Flexible Pages")
	public void flexiblePackages() throws InterruptedException{
		
		homepage.flexiblePackages();
		
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
