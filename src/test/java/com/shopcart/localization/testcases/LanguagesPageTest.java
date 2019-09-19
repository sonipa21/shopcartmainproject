package com.shopcart.localization.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Localization.pages.LanguagesPage;
import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class LanguagesPageTest extends TestBase{

	public LanguagesPageTest() throws FileNotFoundException {
		super();
		
	}
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   LocalizationPage localizationpage;
	   LanguagesPage languagesPage;
		
		@BeforeMethod
		public void setUp() throws Exception
		{
			initialization();
			try {
				loginpage = new LoginPage();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
			dashboardpage.clickOnSpecificLocalizationBtn();
			languagesPage=dashboardpage.clickOnLanguages();
		}
		
		@Test
		public void verifyPageTitleTest()
		{
			String actualTitel=driver.getTitle();
			System.out.println("actual title is"+actualTitel);
			String exceptedTitle="Languages • SHOPCART";
			Assert.assertEquals(actualTitel, exceptedTitle);
			System.out.println("***********");
		}
		
		@Test
		public void verifyAddNewLanguageTest()
		{
			languagesPage.verifyAddNewLanguage();
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

}
