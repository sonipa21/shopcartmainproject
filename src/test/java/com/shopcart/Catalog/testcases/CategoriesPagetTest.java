package com.shopcart.Catalog.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.Catalog.Pages.CategoriesPage;
import com.shopcart.Catalog.Pages.ProductsPage;
import com.shopcart.Localization.pages.LocalizationPage;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class CategoriesPagetTest extends TestBase {

	public CategoriesPagetTest() throws FileNotFoundException {
		super();
		
	}
 
	LoginPage loginpage;
	   DashboardPage dashboardpage;
	   LocalizationPage localizationpage;
	   ProductsPage productsPage;
	   CategoriesPage categoriesPage;
		
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
			categoriesPage=dashboardpage.clickOnCategoriesPage();
		}
		@Test
		public void verifyPageTitleTest()
		{
			String title=driver.getTitle();
			System.out.println("title is:"+title);
			String exceptedTitle="Categories • SHOPCART";
			Assert.assertEquals(title, exceptedTitle);
			System.out.println("*******************");
		}
		@Test
		public void verifyAddNewCategory() throws Exception
		{
			categoriesPage.verifyAddNewCategory();
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		
		
}
