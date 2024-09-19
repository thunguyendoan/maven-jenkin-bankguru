package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.WithdrawalPageObject;

public class Home_Page_Withdrawal extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private WithdrawalPageObject withdrawalPage;


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

        homePage.openDynamicSideBarByPageName("Withdrawal");
        withdrawalPage = PageGeneraterManager.getWithdrawalPage(driver);
    }

    @Test
    public void Withdrawal_01_Empty_Account_No(){
        withdrawalPage.inputToDynamicFieldByName("", "accountno");
        withdrawalPage.clickToSubmitButton();

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("accountno"),"Account Number must not be blank");

    }

    @Test
    public void Withdrawal_02_Not_Number_Account_No(){
        withdrawalPage.inputToDynamicFieldByName("abc", "accountno");

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("accountno"),"Characters are not allowed");

    }

    @Test
    public void Withdrawal_03_Special_Character_Account_No(){
        withdrawalPage.inputToDynamicFieldByName("@", "accountno");

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("accountno"),"Special characters are not allowed");

    }

    @Test
    public void Withdrawal_04_Blank_Character_Account_No(){
        withdrawalPage.inputToDynamicFieldByName(" ", "accountno");

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("accountno"),"Characters are not allowed");

    }

    @Test
    public void Withdrawal_05_Empty_Amount(){
        withdrawalPage.inputToDynamicFieldByName("", "ammount");
        withdrawalPage.clickToSubmitButton();
        withdrawalPage.clickToOKOnAlert();

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("accountno"),"Characters are not allowed");

    }

    @Test
    public void Withdrawal_06_Not_Number_Amount(){
        withdrawalPage.inputToDynamicFieldByName("abc", "ammount");

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("ammount"),"Characters are not allowed");

    }

    @Test
    public void Withdrawal_07_Special_Char_Amount(){
        withdrawalPage.inputToDynamicFieldByName("@", "ammount");

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("ammount"),"Special characters are not allowed");

    }

    @Test
    public void Withdrawal_08_First_Char_Blank_Amount(){
        withdrawalPage.inputToDynamicFieldByName(" ", "ammount");

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("ammount"),"Characters are not allowed");

    }

    @Test
    public void Withdrawal_09_Empty_Desc(){
        withdrawalPage.inputToDynamicFieldByName("", "desc");
        withdrawalPage.clickToSubmitButton();
        withdrawalPage.clickToOKOnAlert();

        Assert.assertEquals(withdrawalPage.getErrorMessageByName("desc"),"Description can not be blank");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
