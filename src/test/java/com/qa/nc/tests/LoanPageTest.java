package com.qa.nc.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.nc.basepage.BasePage;
import com.qa.nc.pages.LoanPage;
import com.qa.nc.utils.Constants;

public class LoanPageTest {
	BasePage basePage;
	WebDriver driver;
	LoanPage loginPage;
	Properties prop;
	@BeforeTest
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initt_prop();
		driver=basePage.initt_driver(prop);
		loginPage=new LoanPage(driver);
	}
	
	@Test(priority=2)
	public void verrifyLoginPageTitleTest(){
		String title=loginPage.getLoginPageTitle();
		System.out.println("Login page title is:" + title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void VerifyResendActivationLinkTest(){
		Assert.assertTrue(loginPage.VerifyResendActivationLink());
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
