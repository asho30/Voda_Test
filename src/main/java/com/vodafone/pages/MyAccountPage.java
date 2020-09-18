package com.vodafone.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;


public class MyAccountPage extends TestBase {

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenCategory;

    @FindBy(xpath = "//a[@title='Blouses']")
    WebElement blousesSubCategory;

    @FindBy(xpath = "//a[@title='Orders']")
    WebElement orderHistoryButton;
    
    public MyAccountPage() {
	PageFactory.initElements(driver, this);
    }

    public BlousesPage openBlousesSubCategory() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']")));
	Actions actions = new Actions(driver);
	actions.moveToElement(womenCategory);
	actions.perform();
	actions.build();
	//womenCategory.click();
	blousesSubCategory.click();
	return new BlousesPage();
    }
    
    public OrderHistoryPage openOrderHistory() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Women']")));
	orderHistoryButton.click();
	return new OrderHistoryPage();
    }
}
