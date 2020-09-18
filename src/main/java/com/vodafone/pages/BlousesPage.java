package com.vodafone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vodafone.base.TestBase;

import org.openqa.selenium.JavascriptExecutor;


public class BlousesPage extends TestBase {


    @FindBy(xpath = "//a/span[text()='Add to cart']")
    WebElement AddToCartButton;

    @FindBy(xpath = "//img[@title='Blouse']")
    WebElement productImage;

    @FindBy(xpath = "//a[@title='Proceed to checkout']/span")
    WebElement proceedToCheckoutButton;

    public BlousesPage() {

	PageFactory.initElements(driver, this);

    }
    public void addProductToCart() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Blouse']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productImage);
	Thread.sleep(1000); 
	Actions actions = new Actions(driver);
	actions.moveToElement(productImage);
	actions.perform();
	actions.build();
	AddToCartButton.click();
    }
    public  ShoppingCartPage proceedToCheckout() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Blouse']")));
	proceedToCheckoutButton.click();
	return new ShoppingCartPage();
    }
}
