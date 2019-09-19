package com.shopcart.Catalog.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.base.TestBase;

public class TagsPage  extends TestBase{

	public TagsPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"page-header-desc-tag-new_tag\"]/i")
	WebElement addnewTag;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//select[@id='id_lang']")
	WebElement languagedropdown;
	
	@FindBy(xpath="//select[@id='select_left']")
	WebElement productsdropdown;
	
	@FindBy(xpath="//a[@id='move_to_right']")
	WebElement addBtn;
	@FindBy(xpath="//*[@id=\"tag_form_submit_btn\"]")
	WebElement saveBtn;
	public void verifyAddnewTag()
	{
		addnewTag.click();
		name.sendKeys("T-shirt");
		Select select=new Select(languagedropdown);
		select.selectByVisibleText("English (English)");
		Select select2=new Select(productsdropdown);
		select2.selectByVisibleText("Faded Short Sleeves T-shirt");
		addBtn.click();
		saveBtn.click();
	}

}
