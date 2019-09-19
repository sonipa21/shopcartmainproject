package com.shopcart.Localization.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class LanguagesPage extends TestBase {

	public LanguagesPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"page-header-desc-lang-new_language\"]/i")
	WebElement addnewLanguageBtn;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement nameLabel;
	@FindBy(xpath="//*[@id=\"iso_code\"]")
	WebElement isoCodeLabel;
	@FindBy(xpath="//*[@id=\"language_code\"]")
	WebElement languagesCode;
	@FindBy(xpath="//*[@id=\"fieldset_0\"]/div[2]/div[9]/div/span/label[1]")
	WebElement rtlLanguagesBtn;
	
	@FindBy(xpath="//*[@id=\"lang_form_submit_btn\"]/i")
	WebElement saveBtn;
	public void verifyAddNewLanguage()
	{
		addnewLanguageBtn.click();
		nameLabel.sendKeys("English (English)");
		isoCodeLabel.sendKeys("en");
		languagesCode.sendKeys("en");
		rtlLanguagesBtn.click();
		saveBtn.click();
	}
	
	
	

}
