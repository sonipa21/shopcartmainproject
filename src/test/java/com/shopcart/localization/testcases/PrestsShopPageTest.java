package com.shopcart.localization.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.Localization.pages.PrestaShopPage;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class PrestsShopPageTest extends TestBase {

	public PrestsShopPageTest() throws FileNotFoundException {
		super();
		
	}
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   LocalizationPage localizationpage;
	   PrestaShopPage prestashopPage;
		
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
		localizationpage=dashboardpage.clickonLocalization();
		}
		
		@Test
		public void verifyPopTest() throws Exception
		{
			localizationpage.verifyModulesAndServices();
			prestashopPage=localizationpage.verifyMoreModulesLink();
			prestashopPage.verifyYesBtn();
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

}
