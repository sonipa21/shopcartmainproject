package com.shopcart.dashboard.testcases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shopcart.Util.CustomListener;
import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;
@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase{

	public LoginPageTest() throws FileNotFoundException {
		super();
	}
   LoginPage loginpage;
   DashboardPage dashboardpage;
   Logger log=Logger.getLogger(LoginPageTest.class);
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		try {
			loginpage = new LoginPage();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest() throws Exception
	{
		log.info("*********Starting loginTestCase********");
		dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login Successfully");
		log.info("*******************ending  loginTest*************");
	}
	
	@Test
	public void verifyPageTitleTest()
	{
		log.info("**********Starting page title test***********");
		String actualTitle=driver.getTitle();
		System.out.println("title is:"+actualTitle);
		String exceptedTitle="SHOPCART > Administration panel (PrestaShop™)";
		Assert.assertEquals(actualTitle, exceptedTitle);
		log.info("*************ending page title test*********");
	}
	
	
	@Test
	public void verifyPageLogoTest()
	{
		
		boolean flag=loginpage.verifypagelogo();
		Assert.assertTrue(flag);
		System.out.println("is logo displyed?"+flag);
		
	}
	@Test
	public void verifyProjectName()
	{
		boolean flag=loginpage.verifyprojectName();
		Assert.assertTrue(flag);
		System.out.println("is project name displayed?"+flag);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("Browser closed");
	}
}
