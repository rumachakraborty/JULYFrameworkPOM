package com.qa.nc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.nc.basepage.BasePage;

public class LoanPage extends BasePage {
	private WebDriver driver;
	
	//1.By locators or OR
	
	By emailid=By.xpath("//input[@name='emailid' and @id='emailid']");
	By password=By.xpath("//input[@type='password' and @id='password' and @name='password']");
	By signup_in=By.xpath("//input[@type='submit' and @id='signup_in']");
    By Resend_Activation=By.xpath("//a[@title='Resend Activation?']");

    
    
    //2.Create constructor of the page
    public LoanPage(WebDriver driver){
    	this.driver=driver;
    	
    	
    }
    
    //3 Create page action or page method
    
    public String getLoginPageTitle(){
    	return driver.getTitle();
    }

    public boolean VerifyResendActivationLink(){
    	return driver.findElement(Resend_Activation).isDisplayed();
    }
    
    
    public HomePage doLogin(String username,String password){
    	driver.findElement(this.emailid).sendKeys(username);
    	driver.findElement(this.password).sendKeys(password);
    	driver.findElement(this.signup_in).click();
    	return new HomePage(driver);
    }
    
}


