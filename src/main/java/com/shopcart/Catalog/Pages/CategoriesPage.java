package com.shopcart.Catalog.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopcart.base.TestBase;

public class CategoriesPage extends TestBase {

	public CategoriesPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"page-header-desc-category-new_category\"]/i")
	WebElement addnewCategoryLink;
	
	@FindBy(xpath="//input[@id='name_1']")
	WebElement nameOfNewCategory;
	@FindBy(xpath="//*[@id=\"expand-all-categories-tree\"]")
	WebElement expandAllLink;
	@FindBy(xpath="//*[@id=\"categories-tree\"]/li/ul/li/ul/li[1]/ul/li[3]/span/input")
	WebElement blousesRadioBtn;
	@FindBy(xpath="//button[@id='image-selectbutton']")
	WebElement addcategorycoverImage;
	@FindBy(xpath="//input[@id='link_rewrite_1']")
	WebElement friendlyUrl;
	@FindBy(xpath="//*[@id=\"category_form_submit_btn\"]")
	WebElement saveBtn;
	
	public void verifyAddNewCategory() throws Exception
	{
		addnewCategoryLink.click();
		nameOfNewCategory.sendKeys("Blouses");
		expandAllLink.click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(blousesRadioBtn));
		blousesRadioBtn.click();
		addcategorycoverImage.click();
		StringSelection filepath= new StringSelection("C:\\Users\\ICE\\Desktop\\category_7.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot rb=new Robot();
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(6000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		friendlyUrl.sendKeys("blouses");
		
		WebDriverWait wait1=new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
	}
	

}
