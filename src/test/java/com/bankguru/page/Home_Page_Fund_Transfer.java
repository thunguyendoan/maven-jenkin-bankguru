package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;

public class Home_Page_Fund_Transfer extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private FundTransferPageObject fundTransferPage;


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

        homePage.openDynamicSideBarByPageName("Fund Transfer");
        fundTransferPage = PageGeneraterManager.getFundTransferPage(driver);

    }

    @Test
    public void Fund_Transfer_01_Empty_Payers(){
        fundTransferPage.inputToFieldNameByName("", "payersaccount");
        fundTransferPage.clickToSubmitButton();

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Payers Account Number must not be blank");

    }

    @Test
    public void Fund_Transfer_02_Not_Number_Payers(){
        fundTransferPage.inputToFieldNameByName("abc", "payersaccount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_03_Special_Character_Payers(){
        fundTransferPage.inputToFieldNameByName("@", "payersaccount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Special characters are not allowed");

    }

    @Test
    public void Fund_Transfer_04_Blank_Character_Payers(){
        fundTransferPage.inputToFieldNameByName(" ", "payersaccount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_05_Empty_Payees(){
        fundTransferPage.inputToFieldNameByName("", "payeeaccount");
        fundTransferPage.clickToSubmitButton();

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_06_Not_Number_Payees(){
        fundTransferPage.inputToFieldNameByName("abc", "payeeaccount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_07_Special_Character_Payees(){
        fundTransferPage.inputToFieldNameByName("@", "payeeaccount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_08_Blank_Character_Payees(){
        fundTransferPage.inputToFieldNameByName(" ", "payeeaccount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("payersaccount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_09_Empty_Amount(){
        fundTransferPage.inputToFieldNameByName("", "ammount");
        fundTransferPage.clickToSubmitButton();
        fundTransferPage.clickToOKOnAlert();

        Assert.assertEquals(fundTransferPage.getErrorMessage("ammount"), "Amount field must not be blank");

    }

    @Test
    public void Fund_Transfer_10_Not_Number_Amount(){
        fundTransferPage.inputToFieldNameByName("abc", "ammount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("ammount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_11_Special_Character_Amount(){
        fundTransferPage.inputToFieldNameByName("@", "ammount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("ammount"), "Special characters are not allowed");

    }

    @Test
    public void Fund_Transfer_12_Blank_Character_Amount(){
        fundTransferPage.inputToFieldNameByName(" ", "ammount");

        Assert.assertEquals(fundTransferPage.getErrorMessage("ammount"), "Characters are not allowed");

    }

    @Test
    public void Fund_Transfer_13_Empty_Desc(){
        fundTransferPage.inputToFieldNameByName("", "desc");
        fundTransferPage.clickToSubmitButton();
        fundTransferPage.clickToOKOnAlert();

        Assert.assertEquals(fundTransferPage.getErrorMessage("desc"), "Description can not be blank");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
