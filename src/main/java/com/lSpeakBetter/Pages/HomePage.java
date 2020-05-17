package com.lSpeakBetter.Pages;

import ISpeakBetterUtilities.Constants;
import ISpeakBetterUtilities.ElementUtil;
import ISpeakBetterUtilities.JavaScriptUtil;
import freemarker.core.ReturnInstruction.Return;

import com.IspeakBetter.Base.BasePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage extends BasePage {

	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	
	
	By header = By.xpath("//h1[@class='rsp']");
	By googlePlayer = By.xpath("//*[@alt='Google Play Store']");
	By appStore = By.xpath("//*[@alt='Apple App Store']");
	By appStoreText = By.xpath("//h1");
	By language= By.xpath("//a[contains(@id,'dropdownMenuLink')]");
	By languages = By.xpath("//div[contains(@class,'dropdown-menu')]");
	By Turkish = By.id("langTr");
	By clickChatBox = By.xpath("//em[@id='zsiq_agtpic']");
	By chatBoxframe = By.xpath("//iframe[@id='siqiframe']");
	By chatBoxText = By.id("attname");
	By closeChatBox = By.xpath("//div[contains(@class,'win_close sqico-larrow')]");
	By duration = By.xpath("//select[@id='class_duration']");
	By length = By.xpath("//select[@id='package_length']");
	By class_week = By.xpath ("//select[@id='per_week_class_number']");
	By courseProgram= By.xpath("//select[@id='course_program']");
	By buybttn = By.xpath("//a[@id='cmdPurchase']");
	By price = By.xpath("//span[@id='result-price']");
	By bluealert = By.xpath("//div[@id='lesson_number_remark']");
	
	
	By firstname = By.xpath("//input[@id='fname']");
	By lastname = By.xpath("//input[@id='lname']");
	By email = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By Confirmpswrd = By.xpath("//input[@id='confirmPass']");
	By timezone = By.xpath("//select[@id='timezone']");
	By phone = By.xpath("//input[@id='mobile']");
	By checkbox = By.xpath("//input[@id='check_term']");
	By checkboxupdate = By.xpath("//input[@id='check_update']");
	By nextbttn = By.xpath("//button[@id='cmdSignupNext']");
	
	
	By classheader= By.xpath("//*[contains(text(),'What do you want to have your classes ')]");
	By monday = By.xpath("//input[@value='mo']");
	By tuesday = By.xpath("//input[@value='tu']");
	By wednesday = By.xpath("//input[@value='we']");
	By thursday = By.xpath("//input[@value='th']");
	By daysnextbttn = By.xpath("//button[contains(@id,'btn-submit-0')]");
	
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil();
		
	}
	public String getHomePageTitle(){
		
	return elementUtil.waitForGetPageTitle("Learn English with Online Teachers - Get your Free Live English Class Now.");
	}
	
	public String getHeader() throws InterruptedException{
		Thread.sleep(3000);
		elementUtil.waitForElementPresent(header);
		return elementUtil.doGetText(header);
	}
	public void verifyGooglePlayer() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println(elementUtil.isElementDisplayed(googlePlayer));
		System.out.println(driver.findElement(googlePlayer).isEnabled());
		
	}
	
	public void verifyAppStore() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println(elementUtil.isElementDisplayed(appStore));
		System.out.println(driver.findElement(appStore).isEnabled());
		elementUtil.doClick(appStore);
		Thread.sleep(3000);
		String apptext = elementUtil.doGetText(appStoreText);
		System.out.println(apptext);
		Assert.assertEquals(apptext, Constants.APPLETEXT);
		
	}


	public String selectLanguage() throws InterruptedException{
		elementUtil.doClick(language);
		
		Thread.sleep(2000);
		elementUtil.doClick(Turkish);
		
		return elementUtil.waitForGetPageTitle("Ücretsiz ders alın.Canlı,bire bir İngilizce dersleri. ISpeakBetter");

	}
		
	
	public void chatBox() throws InterruptedException{
		
		Thread.sleep(2000);
		elementUtil.doClick(clickChatBox);
		Thread.sleep(2000);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(chatBoxframe));
		Thread.sleep(5000);
		elementUtil.doClick(closeChatBox);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
	}
	public void flexiblePackages() throws InterruptedException{
		
		Thread.sleep(3000);
	
		javaScriptUtil.scrollByPixel("0", "1600");
		Thread.sleep(2000);
		
//		List<WebElement> durationlist = driver.findElements(By.xpath("//select[@id='class_duration']/option"));
//		
//		System.out.println(durationlist.size());	
//	for (int i = 0; i < durationlist.size(); i++) {
//			System.out.println(durationlist.get(i).getText());
//			String text = durationlist.get(i).getText();
//				
//		if (text.equals("60")) {
//			durationlist.get(i).click();
//			break;			
//			}
//			}
//			Thread.sleep(3000);
			
			ElementUtil.SelectDropDownValueByText(driver, duration, "60");
			Thread.sleep(1000);
			elementUtil.SelectDropDownValueByText(driver, length, "4 weeks");
			Thread.sleep(1000);
			elementUtil.SelectDropDownValueByText(driver, class_week, "3 Classes");
			Thread.sleep(1000);
			elementUtil.SelectDropDownValueByText(driver, courseProgram, "TOEFL");
			Thread.sleep(1000);
			
		
			String pricetext = elementUtil.doGetText(price);
		
			System.out.println("Price is: " + pricetext);
			Assert.assertEquals(pricetext, "216");
			Thread.sleep(1000);
			String blueAlerttext = elementUtil.doGetText(bluealert);
			System.out.println(blueAlerttext);
			Thread.sleep(1000);
			
			Assert.assertEquals(blueAlerttext, Constants.BLUEALERTTEXT);
			
			System.out.println(elementUtil.isElementDisplayed(buybttn));
			Thread.sleep(1000);
			elementUtil.doClick(buybttn);
			Thread.sleep(3000);
	
		elementUtil.doSendKeys(firstname, "Dila");
		Thread.sleep(1000);
		elementUtil.doSendKeys(lastname, "Yuksel");
		Thread.sleep(1000);
		elementUtil.doSendKeys(email, "duygutibet2027@gmail.com");
		Thread.sleep(1000);
		elementUtil.doSendKeys(password, "12345!");
		Thread.sleep(1000);
		elementUtil.doSendKeys(Confirmpswrd, "12345!");
		Thread.sleep(1000);
		elementUtil.SelectDropDownValueByText(driver, timezone, "Papua New Guinea - Pacific/Port_Moresby");
		Thread.sleep(1000);
		System.out.println(elementUtil.isElementDisplayed(checkbox));
		Thread.sleep(1000);
		elementUtil.doClick(checkbox);
		Thread.sleep(1000);
		System.out.println(driver.findElement(checkbox).isSelected());
		Thread.sleep(1000);
		elementUtil.doClick(checkboxupdate);
		System.out.println(driver.findElement(checkboxupdate).isSelected());
		Thread.sleep(1000);
		elementUtil.doClick(nextbttn);
		Thread.sleep(1000);

	
		String classdaysheader= elementUtil.doGetText(classheader);
		System.out.println(classdaysheader);
		Assert.assertEquals(classdaysheader, Constants.CLASSDAYSHEADER);
		Thread.sleep(1000);
		elementUtil.doClick(monday);
		Thread.sleep(1000);
		elementUtil.doClick(tuesday);
		Thread.sleep(1000);
		elementUtil.doClick(wednesday);
		Thread.sleep(1000);
		elementUtil.doClick(thursday);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Ok!')]")).click(); //alert handling olmadı
	//	elementUtil.getAlertText();
		Thread.sleep(3000);
		
		elementUtil.doClick(daysnextbttn);
		
		Thread.sleep(3000);
		
		
}
	



}
	


	


