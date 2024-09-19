package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;

public class Home_Page_Edit_Customer extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private EditCustomerPageObject editCustomerPage;


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

        homePage.openDynamicSideBarByPageName("Edit Customer");
        editCustomerPage = PageGeneraterManager.getEditCustomerPage(driver);

    }

    @Test
    public void Edit_Account_01_Empty(){
        editCustomerPage.enterToCustomerIDTextbox("");
        editCustomerPage.clickToSubmitButton();

        Assert.assertEquals(editCustomerPage.getErrorMessage(), "Customer ID is required");
    }

    @Test
    public void Edit_Account_02_Not_Number(){
        editCustomerPage.enterToCustomerIDTextbox("abc");

        Assert.assertEquals(editCustomerPage.getErrorMessage(), "Characters are not allowed");
    }

    @Test
    public void Edit_Account_03_Special_Character(){
        editCustomerPage.enterToCustomerIDTextbox("@");

        Assert.assertEquals(editCustomerPage.getErrorMessage(), "Special characters are not allowed");
    }

    @Test
    public void Edit_Account_04_Blank(){
        editCustomerPage.enterToCustomerIDTextbox(" ");

        Assert.assertEquals(editCustomerPage.getErrorMessage(), "First character can not have space");
    }

    @Test
    public void Edit_Account_05_Edit_Customer(){
        editCustomerPage.enterToCustomerIDTextbox(Home_Page_New_Customer.customerID);
        editCustomerPage.clickToSubmitButton();

        editCustomerPage.inputToAddressTextarea("new address");
        editCustomerPage.inputToTextboxByName("new city", "city");
        editCustomerPage.inputToTextboxByName("new state", "state");
        editCustomerPage.inputToTextboxByName("123457", "pinno");
        editCustomerPage.inputToTextboxByName("13", "telephoneno");
        editCustomerPage.inputToTextboxByName("thuthu@noemail.com", "emailid");

        editCustomerPage.clickToSubmitButton();

        editCustomerPage.clickToOKOnAlert();

        editCustomerPage.enterToCustomerIDTextbox(Home_Page_New_Customer.customerID);
        editCustomerPage.clickToSubmitButton();

        Assert.assertEquals(editCustomerPage.getAddressText(), "new address");
        Assert.assertEquals(editCustomerPage.getAttributeValueByName("city"), "new city");
        Assert.assertEquals(editCustomerPage.getAttributeValueByName("state"), "new state");
        Assert.assertEquals(editCustomerPage.getAttributeValueByName("pinno"), "123457");
        Assert.assertEquals(editCustomerPage.getAttributeValueByName("telephoneno"), "13");
        Assert.assertEquals(editCustomerPage.getAttributeValueByName("emailid"), "thuthu@noemail.com");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
