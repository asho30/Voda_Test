package com.vodafone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class SignInPage extends TestBase {


    @FindBy(id="email_create")
    WebElement emailAddressTextBox;

    @FindBy(id="SubmitCreate")
    WebElement submitCreateButton;

    public SignInPage() {

	PageFactory.initElements(driver, this);

    }

    public AuthenticationPage toAuthenticationPage(String userEmail) throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
	System.out.println("userEmail" + userEmail);
	emailAddressTextBox.sendKeys(userEmail);
	submitCreateButton.click();
	return new AuthenticationPage();
    }

}
