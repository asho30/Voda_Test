package com.vodafone.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class PaymentMethodPage extends TestBase {

    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement payByBankWireButton;


    public PaymentMethodPage() {
	PageFactory.initElements(driver, this);
    }

    public BankWirePaymentPage payByBankWire() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='bankwire']")));
	payByBankWireButton.click();
	return new BankWirePaymentPage();
    }
}
