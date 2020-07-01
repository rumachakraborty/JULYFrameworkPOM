package com.qa.nc.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties prop;
	
	/*
	 * This method is used to initialize the webdriver on the basis of browser
	 * @param browserName
	 * @return driver
	 */
	
	public WebDriver initt_driver(Properties prop){
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver=new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
		
		
	}
	
	
	
	
	
public Properties initt_prop(){
	
	//This method is used to initialize the properties from config.properties file
	//return prop
	
	prop=new Properties();
try {
	FileInputStream fs=new FileInputStream("./src/main/java/com/qa/nc/config/config.properties");
	
		prop.load(fs);
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return prop;
		
	}

}
