package com.vodafone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class OrderHistoryPage extends TestBase {

	@FindBy(xpath = "//td[@class='history_method'][text()='Bank wire']")
	WebElement orderRecord;
	
	
	public OrderHistoryPage() {

		PageFactory.initElements(driver, this);
		
	}

	public boolean validateOrder() {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='history_method'][text()='Bank wire']")));
	    return orderRecord.isDisplayed(); 
	}
}
