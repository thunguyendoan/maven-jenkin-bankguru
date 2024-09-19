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
import pageObjects.LogoutPageObject;

public class Home_Page_Logout extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LogoutPageObject logoutPage;


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

        homePage.openDynamicSideBarByPageName("Log out");
        logoutPage = PageGeneraterManager.getLogoutPage(driver);

    }

    @Test
    public void Logout_01_Success(){
        Assert.assertEquals(logoutPage.getTextOnAlert(), "You Have Succesfully Logged Out!!");

        logoutPage.clickOKOnAlert();

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
