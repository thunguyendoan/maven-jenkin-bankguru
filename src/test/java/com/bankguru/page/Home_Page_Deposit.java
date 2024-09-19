package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;

public class Home_Page_Deposit extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private DepositPageObject depositPage;


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

        homePage.openDynamicSideBarByPageName("Deposit");
        depositPage = PageGeneraterManager.getDepositPage(driver);

    }

    @Test
    public void Deposit_01_Empty_Account_No(){
        depositPage.inputToDynamicFieldByName("", "accountno");
        depositPage.clickToSubmitButton();

        Assert.assertEquals(depositPage.getErrorMessageByName("accountno"),"Account Number must not be blank");

    }

    @Test
    public void Deposit_02_Not_Number_Account_No(){
        depositPage.inputToDynamicFieldByName("abc", "accountno");

        Assert.assertEquals(depositPage.getErrorMessageByName("accountno"),"Characters are not allowed");

    }

    @Test
    public void Deposit_03_Special_Character_Account_No(){
        depositPage.inputToDynamicFieldByName("@", "accountno");

        Assert.assertEquals(depositPage.getErrorMessageByName("accountno"),"Special characters are not allowed");

    }

    @Test
    public void Deposit_04_Blank_Character_Account_No(){
        depositPage.inputToDynamicFieldByName(" ", "accountno");

        Assert.assertEquals(depositPage.getErrorMessageByName("accountno"),"Characters are not allowed");

    }

    @Test
    public void Deposit_05_Empty_Amount(){
        depositPage.inputToDynamicFieldByName("", "ammount");
        depositPage.clickToSubmitButton();
        depositPage.clickToOKOnAlert();

        Assert.assertEquals(depositPage.getErrorMessageByName("accountno"),"Characters are not allowed");

    }

    @Test
    public void Deposit_06_Not_Number_Amount(){
        depositPage.inputToDynamicFieldByName("abc", "ammount");

        Assert.assertEquals(depositPage.getErrorMessageByName("ammount"),"Characters are not allowed");

    }

    @Test
    public void Deposit_07_Special_Char_Amount(){
        depositPage.inputToDynamicFieldByName("@", "ammount");

        Assert.assertEquals(depositPage.getErrorMessageByName("ammount"),"Special characters are not allowed");

    }

    @Test
    public void Deposit_08_First_Char_Blank_Amount(){
        depositPage.inputToDynamicFieldByName(" ", "ammount");

        Assert.assertEquals(depositPage.getErrorMessageByName("ammount"),"Characters are not allowed");

    }

    @Test
    public void Deposit_09_Empty_Desc(){
        depositPage.inputToDynamicFieldByName("", "desc");
        depositPage.clickToSubmitButton();
        depositPage.clickToOKOnAlert();

        Assert.assertEquals(depositPage.getErrorMessageByName("desc"),"Description can not be blank");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
