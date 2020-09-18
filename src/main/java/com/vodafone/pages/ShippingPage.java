package com.vodafone.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class ShippingPage extends TestBase {

    @FindBy(xpath = "//button[@type='submit'][@name='processCarrier']/span")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@name='cgv']")
    WebElement termsCheckbox;


    public ShippingPage() {
	PageFactory.initElements(driver, this);
    }

    public PaymentMethodPage confirmShipping() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='cgv']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", proceedToCheckoutButton);
	Thread.sleep(1000); 
	termsCheckbox.click();
	proceedToCheckoutButton.click();
	return new PaymentMethodPage();
    }
}
