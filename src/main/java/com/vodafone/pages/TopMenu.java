package com.vodafone.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class TopMenu extends TestBase {
	
	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signInButton;
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement profileButton;
	
	public TopMenu() {

		PageFactory.initElements(driver, this);
		
	}
	
	public  String getTitle() {
		String actualTitle =driver.getTitle();
		return actualTitle;
	}
	
	public SignInPage toSignInPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Log in to your customer account']")));
	    signInButton.click();
		return new SignInPage();
	}

	public MyAccountPage toCustomerAccountPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='View my customer account']")));
	    profileButton.click();
		return new MyAccountPage();
	}
}
