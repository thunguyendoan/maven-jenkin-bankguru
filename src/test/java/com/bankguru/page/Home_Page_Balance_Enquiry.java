package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.HomePageObject;

public class Home_Page_Balance_Enquiry extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private BalanceEnquiryPageObject balanceEnquiryPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = OpenMultipleBrowserDriver(browserName);
        openURL(driver, "https://demo.guru99.com/v4/index.php");
        homePage = PageGeneraterManager.getHomePage(driver);

        homePage.enterToUserIDTextbox(New_Account_Login.userID);
        homePage.enterToPasswordTextbox(New_Account_Login.password);
        homePage.clickToLoginButton();

        Assert.assertEquals(homePage.getMangerID(),"Manger Id : " + New_Account_Login.userID);

        homePage.openDynamicSideBarByPageName("Edit Account");
        balanceEnquiryPage = PageGeneraterManager.getBalanceEnquiryPage(driver);

    }

    @Test
    public void Balance_Enquiry_01_Empty_CustomerID(){
        balanceEnquiryPage.inputToAccountNoTextbox("");
        balanceEnquiryPage.clickToSubmitButton();

        Assert.assertEquals(balanceEnquiryPage.getErrorMessage(), "Account Number must not be blank");

    }

    @Test
    public void Balance_Enquiry_02_Not_Number_CustomerID(){
        balanceEnquiryPage.inputToAccountNoTextbox("a");

        Assert.assertEquals(balanceEnquiryPage.getErrorMessage(), "Characters are not allowed");

    }

    @Test
    public void Balance_Enquiry_03_Special_Char_CustomerID(){
        balanceEnquiryPage.inputToAccountNoTextbox("@");

        Assert.assertEquals(balanceEnquiryPage.getErrorMessage(), "Special characters are not allowed");

    }

    @Test
    public void Balance_Enquiry_04_First_Char_Blank_CustomerID(){
        balanceEnquiryPage.inputToAccountNoTextbox(" ");

        Assert.assertEquals(balanceEnquiryPage.getErrorMessage(), "Characters are not allowed");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
