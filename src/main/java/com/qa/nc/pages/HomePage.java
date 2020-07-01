package com.qa.nc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.nc.basepage.BasePage;

public class HomePage extends BasePage {
	private WebDriver driver;
	
	By header=By.cssSelector("h1.page-header17");
	
public HomePage(WebDriver driver){
	this.driver=driver;
	
}


public String getHomePageTitle(){
	return driver.getTitle();
}

public String getHomePageHeaderText(){
	if(driver.findElement(header).isDisplayed()){
		return driver.findElement(header).getText();
	}
	return null;
}
}