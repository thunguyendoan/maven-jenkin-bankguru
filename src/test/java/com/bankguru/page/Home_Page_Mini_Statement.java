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
import pageObjects.MiniStatementPageObject;

public class Home_Page_Mini_Statement extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private MiniStatementPageObject miniStatementPage;


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

        homePage.openDynamicSideBarByPageName("Mini Statement");
        miniStatementPage = PageGeneraterManager.getMiniStatementPage(driver);


    }

    @Test
    public void Mini_Statement_01_Empty(){
        miniStatementPage.enterToAccountNoTextbox("");
        miniStatementPage.clickToSubmitButton();

        Assert.assertEquals(miniStatementPage.getErrorMessage(), "Account Number must not be blank");

    }

    @Test
    public void Mini_Statement_02_Not_Number(){
        miniStatementPage.enterToAccountNoTextbox("abc");

        Assert.assertEquals(miniStatementPage.getErrorMessage(), "Characters are not allowed");
    }

    @Test
    public void Mini_Statement_03_Special_Character(){
        miniStatementPage.enterToAccountNoTextbox("@");

        Assert.assertEquals(miniStatementPage.getErrorMessage(), "Special characters are not allowed");
    }

    @Test
    public void Mini_Statement_04_Blank_Character(){
        miniStatementPage.enterToAccountNoTextbox(" ");

        Assert.assertEquals(miniStatementPage.getErrorMessage(), "Characters are not allowed");
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
