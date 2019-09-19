package com.shopcart.localization.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.Localization.pages.PrestaShopPage;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class LocalizationPageTest extends TestBase
{

	public LocalizationPageTest() throws FileNotFoundException {
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
		public void verifyPageTitleTest()
		{
			String actualTitle=driver.getTitle();
			System.out.println("title is"+actualTitle);
			String exceptedTitle="Localization • SHOPCART";
			Assert.assertEquals(actualTitle, exceptedTitle);
			System.out.println("*************");
		}
		
		@Test
		public void verifyPanelHeadingTest()
		{
			boolean flag=localizationpage.verifyPanelHeading();
			System.out.println("is panel headin displayed?"+flag);
		}
		
		@Test
		public void verifypackToImportTest() throws InterruptedException
		{
			localizationpage.verifyPackToImport();
		}
		
		@Test
		public void verifyCheckBoxTest()
		{
			localizationpage.verifyCheckBox();
		}
		
		@Test
		public void verifyRadioButton()
		{
			localizationpage.verifyRadioButton();
		}
		
		@Test
		public void verifyLanguageSliderTest()
		{
			localizationpage.verifyLanguageSlider();
		}
		@Test
		public void verifyConfigrationTest() throws Exception
		{
			localizationpage.verifyconfigration();
		}
		
		@Test
		public void verifyModulesAndServices() throws Exception
		{
			localizationpage.verifyModulesAndServices();
			prestashopPage=localizationpage.verifyMoreModulesLink();
			
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

}
