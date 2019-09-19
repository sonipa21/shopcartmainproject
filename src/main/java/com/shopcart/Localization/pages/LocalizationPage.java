package com.shopcart.Localization.pages;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.shopcart.base.TestBase;

public class LocalizationPage extends TestBase {

	public LocalizationPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"maintab-AdminParentLocalization\"]/a/span")
	WebElement localizationBtn;
	
	@FindBy(xpath="//*[@id=\"configuration_fieldset_general\"]/div[1]")
	WebElement panelHeading;
	

   @FindBy(css="#selection\\[\\]_groups")
   WebElement chekbox;
   
   @FindBy(xpath="//input[@id='download_updated_pack_no']")
   WebElement radioButton;
   
   @FindBy(xpath="//label[@for='PS_DETECT_LANG_off']")
   WebElement languageSlider;
   
   @FindBy(xpath="//*[@id=\"PS_LANG_DEFAULT\"]")
   WebElement languageDropdown;
   
   @FindBy(xpath="//*[@id=\"PS_COUNTRY_DEFAULT_chosen\"]")
   WebElement statesDropDown;
	
   @FindBy(xpath="//*[@id=\"PS_COUNTRY_DEFAULT_chosen\"]/div/div/input")
   WebElement countrydropdown;
   
   @FindBy(xpath="//button[@name='submitOptionsconfiguration'][1]")
   WebElement saveBtn;
   @FindBy(xpath="//div[@class='alert alert-success']")
   WebElement successMsg;
   
   @FindBy(xpath="//i[@class='process-icon-modules-list']")
   WebElement modulesLink;
   @FindBy(linkText="More modules on addons.prestashop.com")
   WebElement moreModulesLink;
   @FindBy(xpath="//a[@class='btn btn-xsmall btn-plain btn-secondary right ok-cookie']")
   WebElement okBtn;
   @FindBy(xpath="//button[@class='align-right primary popover-button']")
   WebElement yesBtn;
	public boolean verifyPanelHeading()
	{
		return panelHeading.isDisplayed();
	}
	
	public void verifyPackToImport() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"iso_localization_pack_chosen\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"iso_localization_pack_chosen\"]/div/div/input")).sendKeys("Australia",Keys.ENTER);
		Thread.sleep(2000);
		Select s=new Select(driver.findElement(By.xpath("//select[@name='iso_localization_pack']")));
		s.selectByVisibleText("Australia");
	}
	public void verifyCheckBox()
	{
		chekbox.click();
	}
	public void verifyRadioButton()
	{
		radioButton.click();
	}
	
	public void verifyLanguageSlider()
	{
		languageSlider.click();
	}
	public void verifyconfigration() throws InterruptedException
	{
		Thread.sleep(2000);
		Select select=new Select(languageDropdown);
		select.selectByVisibleText("English (English)");
		languageSlider.click();
		
		saveBtn.click();
		String actual=successMsg.getText();
		System.out.println("msg is"+actual);
		String excepted="The settings have been successfully updated.";
		Assert.assertEquals(actual, excepted);
	}
	
	public void verifyModulesAndServices() throws InterruptedException
	{
		modulesLink.click();
		
	}
	public PrestaShopPage verifyMoreModulesLink() throws Exception
	{
		moreModulesLink.click();
		return new PrestaShopPage();
		
	}
	

}
