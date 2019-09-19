package com.shopcart.Orders.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class InvoicesPae  extends TestBase{

	public InvoicesPae() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"date_from\"]")
	WebElement fromBtn;
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")
	WebElement monthlink;
	@FindBy(xpath="//*[@id=\"date_to\"]")
	WebElement toBtn;
	@FindBy(xpath="//*[@id=\"submitPrint\"]")
	WebElement generateBtn;
	public void verifyfromDate() throws InterruptedException
	{
		fromBtn.click();
		String date="2019-08-15";
		String dateArr[]=date.split("-");
		String day=dateArr[2];
		String beforexpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
		String afterxpath="]/td[";
		final int totalWeekDays=7;
		boolean flag=false;
		
		for(int rowNum=1;rowNum<=5;rowNum++)
		{
			for(int colNum=1;colNum<=totalWeekDays;colNum++)
			{
			String dayVal=	driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).getText();
			System.out.println(dayVal);
			if(dayVal.equals(day))
         {
				Thread.sleep(2000);
				driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).click();
				flag=true;
				break;
          }

			}
			if(flag)
			{
				break;
			}
		}
		
		//*[@id="ui-datepicker-div"]/table/tbody/tr[2]/td[1]/a
		//*[@id="ui-datepicker-div"]/table/tbody/tr[2]/td[2]/a
		//*[@id="ui-datepicker-div"]/table/tbody/tr[2]/td[6]/a
	}
	public void toDate() throws Exception
	{
		toBtn.click();
		String date="2019-08-20";
		String dateArr[]=date.split("-");
		String day=dateArr[2];
		String beforexpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
		String afterxpath="]/td[";
		final int totalWeekDays=7;
		boolean flag=false;
		
		for(int rowNum=1;rowNum<=5;rowNum++)
		{
			for(int colNum=1;colNum<=totalWeekDays;colNum++)
			{
			String dayVal=	driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).getText();
			System.out.println(dayVal);
			if(dayVal.equals(day))
         {
				Thread.sleep(2000);
				driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).click();
				flag=true;
				break;
          }

			}
			if(flag)
			{
				break;
			}
		}
		
		
	}
	public void clickOnGenerateBtn()
	{
		generateBtn.click();
	}

}
