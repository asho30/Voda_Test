package com.vodafone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class AuthenticationPage extends TestBase {

    @FindBy(id="id_gender1")
    WebElement titleMrRadioButton;

    @FindBy(id="id_gender2")
    WebElement titleMrsRadioButton;

    @FindBy(id="customer_firstname")
    WebElement firstnameTextBox;

    @FindBy(id="customer_lastname")
    WebElement lastnameTextBox;

    @FindBy(id="email")
    WebElement emailTextBox;

    @FindBy(id="passwd")
    WebElement passwordTextBox;

    @FindBy(id="days")
    WebElement dateOfBirth_DaySelect;

    @FindBy(id="months")
    WebElement dateOfBirth_MonthSelect;

    @FindBy(id="years")
    WebElement dateOfBirth_YearSelect;

    @FindBy(id="newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id="optin")
    WebElement offersCheckbox;

    @FindBy(id="firstname")
    WebElement firstnameAddressTextBox;

    @FindBy(id="lastname")
    WebElement lastnameAddressTextBox;

    @FindBy(id="company")
    WebElement companyAddressTextBox;

    @FindBy(id="address1")
    WebElement addressTextBox;

    @FindBy(id="address2")
    WebElement address2TextBox;

    @FindBy(id="city")
    WebElement cityAddressTextBox;

    @FindBy(id="id_state")
    WebElement stateAddressSelect;

    @FindBy(id="postcode")
    WebElement postCodeAddressTextBox;

    @FindBy(id="id_country")
    WebElement countryAddressSelect;

    @FindBy(id="other")
    WebElement additionalInformationAddressTextBox;

    @FindBy(id="phone")
    WebElement phoneHomeAddressTextBox;

    @FindBy(id="phone_mobile")
    WebElement phoneMobileAddressTextBox;

    @FindBy(id="alias")
    WebElement aliasAddressTextBox;

    @FindBy(id="submitAccount")
    WebElement registerButton;

    String xpath;
    public AuthenticationPage() {

	PageFactory.initElements(driver, this);

    }

    public MyAccountPage authenticateNewUser(String[] authenticationData) throws Exception {

	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alias")));
	
	if(authenticationData[0].toString().equalsIgnoreCase("mr")) {
	    titleMrRadioButton.click();
	}else if (authenticationData[0].toString().equalsIgnoreCase("mrs")) {
	    titleMrsRadioButton.click();
	}

	firstnameTextBox.sendKeys(authenticationData[1].toString());
	lastnameTextBox.sendKeys(authenticationData[2].toString());
	emailTextBox.clear();
	emailTextBox.sendKeys(authenticationData[3].toString());
	passwordTextBox.sendKeys(authenticationData[4].toString());

	dateOfBirth_DaySelect.click();
	xpath = "//select[@id='days']/option[@value='" + authenticationData[5].toString() + "']";
	WebElement daysOption = driver.findElement(By.xpath(xpath));
	daysOption.click();

	dateOfBirth_MonthSelect.click();
	xpath = "//select[@id='months']/option[@value='" + authenticationData[6].toString() + "']";
	WebElement monthsOption = driver.findElement(By.xpath(xpath));
	monthsOption.click();

	dateOfBirth_YearSelect.click();
	xpath = "//select[@id='years']/option[@value='" + authenticationData[7].toString() + "']";
	WebElement yearsOption = driver.findElement(By.xpath(xpath));
	yearsOption.click();

	if(authenticationData[8].toString().equalsIgnoreCase("yes")) {
	    newsletterCheckbox.click();
	}

	if(authenticationData[9].toString().equalsIgnoreCase("yes")) {
	    offersCheckbox.click();
	}

	firstnameAddressTextBox.sendKeys(authenticationData[10].toString());
	lastnameAddressTextBox.sendKeys(authenticationData[11].toString());
	if ((authenticationData[12] != null) && (authenticationData[12] != "")) {
	    companyAddressTextBox.sendKeys(authenticationData[12].toString());
	}

	addressTextBox.sendKeys(authenticationData[13].toString());
	if ((authenticationData[14] != null) && (authenticationData[14] != "")) {
	    address2TextBox.sendKeys(authenticationData[14].toString());
	}

	cityAddressTextBox.sendKeys(authenticationData[15].toString());

	stateAddressSelect.click();
	xpath = "//select[@id='id_state']/option[text()='" + authenticationData[16].toString() + "']";
	WebElement stateOption = driver.findElement(By.xpath(xpath));
	stateOption.click();

	postCodeAddressTextBox.sendKeys(authenticationData[17].toString());

	countryAddressSelect.click();
	xpath = "//select[@id='id_country']/option[text()='" + authenticationData[18].toString() + "']";
	WebElement countryOption = driver.findElement(By.xpath(xpath));
	countryOption.click();

	if ((authenticationData[19] != null) && (authenticationData[19] != "")) {
	    additionalInformationAddressTextBox.sendKeys(authenticationData[19].toString());
	}

	if ((authenticationData[20] != null) && (authenticationData[20] != "")) {
	    phoneHomeAddressTextBox.sendKeys(authenticationData[20].toString());
	}

	phoneMobileAddressTextBox.sendKeys(authenticationData[21].toString());
	aliasAddressTextBox.clear();
	aliasAddressTextBox.sendKeys(authenticationData[22].toString());
	registerButton.click();
	return new MyAccountPage();
    }
}
