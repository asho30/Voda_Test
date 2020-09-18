package com.vodafone.testcases;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vodafone.base.TestBase;
import com.vodafone.pages.AddressesPage;
import com.vodafone.pages.AuthenticationPage;
import com.vodafone.pages.BankWirePaymentPage;
import com.vodafone.pages.BlousesPage;
import com.vodafone.pages.MyAccountPage;
import com.vodafone.pages.OrderHistoryPage;
import com.vodafone.pages.PaymentMethodPage;
import com.vodafone.pages.ShippingPage;
import com.vodafone.pages.ShoppingCartPage;
import com.vodafone.pages.SignInPage;
import com.vodafone.pages.TopMenu;
import com.vodafone.utils.TestUtil;


public class vodafone_Test extends TestBase {


    String userEmail;
    String[] authenticationData;
    int startRowNumber,endRowNumber;

    TopMenu topMenu;
    BlousesPage blousesPage;
    ShoppingCartPage shoppingCartPage;
    MyAccountPage myAccountPage;
    AuthenticationPage authenticationPage;
    SignInPage signInPage; 
    AddressesPage addressesPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;
    BankWirePaymentPage bankWirePaymentPage;
    OrderHistoryPage orderHistoryPage;

    public vodafone_Test() {
	super();
    }

    @BeforeClass
    public void beforeClass() {

    }

    @BeforeMethod
    public void start(Method method) throws InterruptedException, Throwable {

	logger = extent.startTest(method.getName());
	initialization(prop.getProperty("url"));
	startRowNumber = Integer.parseInt(prop.getProperty("startRowDataNumber"));
	endRowNumber = Integer.parseInt(prop.getProperty("endRowDataNumber"));
	pagesInitialization();
    }

    @Test(priority = 1)
    public void TC_HighLevelScenario() throws Exception {
	for(int rowNumber = startRowNumber; rowNumber <= endRowNumber; rowNumber++) {
	    if(rowNumber != 1) { 
		initialization(prop.getProperty("url"));
		pagesInitialization();
	    }
	    // read test data
	    authenticationData = readAuthenticationData(rowNumber);
	    topMenu.toSignInPage().toAuthenticationPage(authenticationData[3]).authenticateNewUser(authenticationData)
	    .openBlousesSubCategory().addProductToCart();
	    blousesPage.proceedToCheckout().confirmShoppingCart().confirmAddresses().confirmShipping().payByBankWire()
	    .confirmOrder();
	    Assert.assertTrue(topMenu.toCustomerAccountPage().openOrderHistory().validateOrder());
	    Thread.sleep(2000);
	    driver.quit();
	}
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Throwable {

	if (result.getStatus() == ITestResult.FAILURE) {

	    logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
	    String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
	    logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));


	} else if (result.getStatus() == ITestResult.SKIP) {
	    logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

	} else {
	    logger.log(LogStatus.PASS, "Test passed");
	    String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
	    logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));

	}

	extent.endTest(logger);
	driver.quit();
    }


    private void pagesInitialization() {
	topMenu = new TopMenu();
	blousesPage = new BlousesPage();
	shoppingCartPage = new ShoppingCartPage();
	myAccountPage = new MyAccountPage();
	authenticationPage = new AuthenticationPage();
	signInPage = new SignInPage();
	addressesPage = new AddressesPage();
	shippingPage = new ShippingPage();
	paymentMethodPage = new PaymentMethodPage();
	bankWirePaymentPage = new BankWirePaymentPage();
	orderHistoryPage = new OrderHistoryPage();
    }

    private String[] readAuthenticationData(int rowNumber) throws IOException {
	ArrayList<String> authenticationData = new ArrayList<String>();
	String inputFileName = prop.getProperty("testDataFolderPath");
	String sheetName = prop.getProperty("sheetName");
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Title", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Firstname", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Lastname", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Email", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Password", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Day Of Birth", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Month Of Birth", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Year Of Birth", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Newsletter", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Offers", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Firstname Address", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Lastname Address", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Company Address", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Address", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Address Line 2", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "City", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "State", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "PostCode", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Country", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Additional Information", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Home Phone", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Mobile Phone", rowNumber));
	authenticationData.add(TestUtil.readFromExcelFile(inputFileName, sheetName, "Alias", rowNumber));
	System.out.println("Return readAuthenticationData");
	return authenticationData.toArray(new String[0]);
    }
}
