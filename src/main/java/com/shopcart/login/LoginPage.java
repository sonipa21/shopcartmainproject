package com.shopcart.login;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;

public class LoginPage extends TestBase{
	public LoginPage() throws FileNotFoundException {
		super();
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement username;
	
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login_form\"]/div[3]/button")
	WebElement login;
	
	@FindBy(xpath="//img[@id='logo']")
	WebElement loginPagelogo;
	
	@FindBy(xpath="//*[@id=\"shop_name\"]")
	WebElement shopName;
	
	@FindBy(linkText="I forgot my password")
	WebElement fogotPwdLink;
	
	public boolean verifypagelogo()
	{
		return loginPagelogo.isDisplayed();
	}
	
	public boolean verifyprojectName()
	{
		return shopName.isDisplayed();
	}
	
	public void verifyForgotPasswordLink()
	{
		fogotPwdLink.click();
	}
	
	public DashboardPage Username(String uname,String pwd) throws Exception
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
		return new DashboardPage();
	}

}
