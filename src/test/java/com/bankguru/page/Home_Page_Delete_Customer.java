package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;

public class Home_Page_Delete_Customer extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private DeleteCustomerPageObject deleteCustomerPage;


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

        homePage.openDynamicSideBarByPageName("Delete Customer");
        deleteCustomerPage = PageGeneraterManager.getDeleteCustomerPage(driver);

    }

    @Test
    public void Delete_Customer_01_Empty(){
        deleteCustomerPage.enterToCustomerIDTextbox("");
        deleteCustomerPage.clickToSubmitButton();

        Assert.assertEquals(deleteCustomerPage.getErrorMessage(), "Customer ID is required");

    }

    @Test
    public void Delete_Customer_02_Not_Number(){
        deleteCustomerPage.enterToCustomerIDTextbox("abc");

        Assert.assertEquals(deleteCustomerPage.getErrorMessage(), "Characters are not allowed");

    }

    @Test
    public void Delete_Customer_03_Special_Character(){
        deleteCustomerPage.enterToCustomerIDTextbox("@");

        Assert.assertEquals(deleteCustomerPage.getErrorMessage(), "Special characters are not allowed");

    }

    @Test
    public void Delete_Customer_04_Blank_Character(){
        deleteCustomerPage.enterToCustomerIDTextbox(" ");

        Assert.assertEquals(deleteCustomerPage.getErrorMessage(), "First character can not have space");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
