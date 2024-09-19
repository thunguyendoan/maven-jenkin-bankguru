package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;

public class Home_Page_Edit_Account extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private EditAccountPageObject editAccountPage;


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
        editAccountPage = PageGeneraterManager.getEditAccountPage(driver);

    }

    @Test
    public void Edit_Account_01_Empty_CustomerID(){
        editAccountPage.inputToAccountNoTextbox("");
        editAccountPage.clickToSubmitButton();

        Assert.assertEquals(editAccountPage.getErrorMessage(), "Account Number must not be blank");

    }

    @Test
    public void Edit_Account_02_Not_Number_CustomerID(){
        editAccountPage.inputToAccountNoTextbox("a");

        Assert.assertEquals(editAccountPage.getErrorMessage(), "Characters are not allowed");

    }

    @Test
    public void Edit_Account_03_Special_Char_CustomerID(){
        editAccountPage.inputToAccountNoTextbox("@");

        Assert.assertEquals(editAccountPage.getErrorMessage(), "Special characters are not allowed");

    }

    @Test
    public void Edit_Account_04_First_Char_Blank_CustomerID(){
        editAccountPage.inputToAccountNoTextbox(" ");

        Assert.assertEquals(editAccountPage.getErrorMessage(), "Characters are not allowed");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
