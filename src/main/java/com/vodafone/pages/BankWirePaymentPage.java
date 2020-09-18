package com.vodafone.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class BankWirePaymentPage extends TestBase {

    @FindBy(xpath = "//p[@id=\"cart_navigation\"]/button[@type='submit']")
    WebElement confirmMyOrderButton;


    public BankWirePaymentPage() {
	PageFactory.initElements(driver, this);
    }

    public TopMenu confirmOrder() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'Bank-wire payment')]")));
	confirmMyOrderButton.click();
	return new TopMenu();
    }
}
