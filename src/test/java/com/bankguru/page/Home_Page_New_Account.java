package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageNewAccountPageObject;
import pageObjects.HomePageObject;

public class Home_Page_New_Account extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private HomePageNewAccountPageObject homePageNewAccountPage;
    public static String accountNumber;


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

        homePage.openDynamicSideBarByPageName("New Account");
        homePageNewAccountPage = PageGeneraterManager.getHomePageNewAccountPage(driver);

    }

    @Test
    public void New_Account_01_Empty_CustomerID(){
        homePageNewAccountPage.inputToFieldNameByName("", "cusid");
        homePageNewAccountPage.clickToSubmitButton();

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("cusid"), "Customer ID is required");

    }

    @Test
    public void New_Account_02_Not_Number_CustomerID(){
        homePageNewAccountPage.inputToFieldNameByName("a", "cusid");

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("cusid"), "Characters are not allowed");

    }

    @Test
    public void New_Account_03_Special_Char_CustomerID(){
        homePageNewAccountPage.inputToFieldNameByName("@", "cusid");

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("cusid"), "Special characters are not allowed");

    }

    @Test
    public void New_Account_04_First_Char_Blank_CustomerID(){
        homePageNewAccountPage.inputToFieldNameByName(" ", "cusid");

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("cusid"), "First character can not have space");

    }

    @Test
    public void New_Account_05_Empty_Deposit(){
        homePageNewAccountPage.inputToFieldNameByName("", "inideposit");
        homePageNewAccountPage.clickToSubmitButton();
        homePageNewAccountPage.clickToOKOnAlert();

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("inideposit"), "Initial Deposit must not be blank");

    }

    @Test
    public void New_Account_06_Not_Number_Deposit(){
        homePageNewAccountPage.inputToFieldNameByName("a", "inideposit");

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("inideposit"), "Characters are not allowed");

    }

    @Test
    public void New_Account_07_Special_Char_Deposit(){
        homePageNewAccountPage.inputToFieldNameByName("@", "inideposit");

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("inideposit"), "Special characters are not allowed");

    }

    @Test
    public void New_Account_08_First_Char_Blank_Deposit(){
        homePageNewAccountPage.inputToFieldNameByName("@", "inideposit");

        Assert.assertEquals(homePageNewAccountPage.getErrorMessageByName("inideposit"), "Special characters are not allowed");

    }

    @Test
    public void New_Account_08_Valid_CustomerID_Account_Type_Current(){
        homePageNewAccountPage.refreshPage();

        homePageNewAccountPage.inputToFieldNameByName(Home_Page_New_Customer.customerID, "cusid");
        homePageNewAccountPage.inputToAccountTypeDropdown("Current");
        homePageNewAccountPage.inputToFieldNameByName("10000", "inideposit");
        homePageNewAccountPage.clickToSubmitButton();

        Assert.assertEquals(homePageNewAccountPage.getMessageSuccess(), "Account Generated Successfully!!!");

        accountNumber = homePageNewAccountPage.getTextByRowName("Account ID");
        System.out.println(accountNumber);
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Customer ID"), Home_Page_New_Customer.customerID);
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Customer Name"), Home_Page_New_Customer.customerName);
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Account Type"), "Current");
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Current Amount"), "10000");

    }

    @Test
    public void New_Account_09_Valid_CustomerID_Account_Type_Saving(){
        homePageNewAccountPage.openDynamicSideBarByPageName("New Account");

        homePageNewAccountPage.inputToFieldNameByName(Home_Page_New_Customer.customerID, "cusid");
        homePageNewAccountPage.inputToAccountTypeDropdown("Savings");
        homePageNewAccountPage.inputToFieldNameByName("20000", "inideposit");
        homePageNewAccountPage.clickToSubmitButton();

        Assert.assertEquals(homePageNewAccountPage.getMessageSuccess(), "Account Generated Successfully!!!");

        accountNumber = homePageNewAccountPage.getTextByRowName("Account ID");
        System.out.println(accountNumber);
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Customer ID"), Home_Page_New_Customer.customerID);
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Customer Name"), Home_Page_New_Customer.customerName);
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Account Type"), "Savings");
        Assert.assertEquals(homePageNewAccountPage.getTextByRowName("Current Amount"), "20000");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
