package com.IspeakBetter.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initialize_driver(Properties prop){
		
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (headless.equalsIgnoreCase("yes")) {
				ChromeOptions cOptions = new ChromeOptions();
				cOptions.addArguments("--headless");
				driver= new ChromeDriver(cOptions);
			}else {
				driver = new ChromeDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public Properties initialize_properties(){
		
		prop = new Properties();
		try {
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")
					+"/src/main/java/config/ISpeakBetter/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return prop;
	}
	public void closeBrowser(){
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Some exception occured while closing browser");
		
		}
	}
}
