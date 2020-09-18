package com.vodafone.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class AddressesPage extends TestBase {

    @FindBy(xpath = "//button[@type='submit']/span[text()='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public AddressesPage() {
	PageFactory.initElements(driver, this);
    }

    public ShippingPage confirmAddresses() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']/span[text()='Proceed to checkout']")));
	proceedToCheckoutButton.click();
	return new ShippingPage();
    }
}
