package com.shopcart.Localization.pages;

import java.io.FileNotFoundException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class PrestaShopPage extends TestBase {

	public PrestaShopPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"cookie\"]/p[2]/a[2]")
	WebElement okBtn;
	@FindBy(xpath="//button[@class='align-right primary popover-button']")
	WebElement yesBtn;
	public void verifyOkBtn()
	{
		okBtn.click();
	}
	public void verifyYesBtn()
	{
		yesBtn.click();
		Set<String> handle=driver.getWindowHandles();
		System.out.println(handle);
		for(String handle1:handle)
		{
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
		
		
	}

	
}
