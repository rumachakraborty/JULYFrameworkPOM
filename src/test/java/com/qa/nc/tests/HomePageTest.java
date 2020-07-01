package com.qa.nc.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.nc.basepage.BasePage;
import com.qa.nc.pages.HomePage;
import com.qa.nc.pages.LoanPage;
import com.qa.nc.utils.Constants;

public class HomePageTest {
	BasePage basePage;
	WebDriver driver;
	LoanPage loginPage;
	HomePage homePage;
	Properties prop;
	
	@BeforeTest
	public void setup(){
		
		 basePage=new BasePage();
		 prop=basePage.initt_prop();
		driver=basePage.initt_driver(prop);
		 loginPage=new LoanPage(driver);
		 homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 //homePage=loginPage.doLogin("sobha1@gmail.com","super2017@");
	}
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String title=homePage.getHomePageTitle();
		System.out.println("Home page title is :" +title);
		Assert.assertEquals(title,Constants.Home_PAGE_TITLEE,"home page title is not matched-----------");
	}
	@Test(priority=2)
	public void verifyHomePageHeader(){
		String header=homePage.getHomePageHeaderText();
		System.out.println("Home Page header is" +header);
		Assert.assertEquals(header,"Dashboard","Home page header is not present---");
				}
	
	
	
	//@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
