package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomisedStatementPageObject;
import pageObjects.HomePageObject;

public class Home_Page_Customised_Statement extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private CustomisedStatementPageObject customisedStatementPage;


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

        homePage.openDynamicSideBarByPageName("Customised Statement");
        customisedStatementPage = PageGeneraterManager.getCustomisedStatementPage(driver);

    }

    @Test
    public void Delete_Customer_01_Empty_Account_No(){
        customisedStatementPage.enterToFieldNameByName("", "accountno");
        customisedStatementPage.clickToSubmitButton();

        Assert.assertEquals(customisedStatementPage.getErrorMessage("accountno"), "Account Number must not be blank");

    }

    @Test
    public void Delete_Customer_02_Not_Number_Account_No(){
        customisedStatementPage.enterToFieldNameByName("abc", "accountno");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("accountno"), "Characters are not allowed");

    }

    @Test
    public void Delete_Customer_03_Special_Character_Account_No(){
        customisedStatementPage.enterToFieldNameByName("@", "accountno");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("accountno"), "Special characters are not allowed");

    }

    @Test
    public void Delete_Customer_04_Blank_Character_Account_No(){
        customisedStatementPage.enterToFieldNameByName(" ", "accountno");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("accountno"), "Characters are not allowed");

    }

    @Test
    public void Delete_Customer_05_Empty_From_Date(){
        customisedStatementPage.enterToFieldNameByName("", "fdate");
        customisedStatementPage.clickToSubmitButton();
        customisedStatementPage.clickOnOKAlert();

        Assert.assertEquals(customisedStatementPage.getErrorMessage("fdate"), "From Date Field must not be blank");

    }

    @Test
    public void Delete_Customer_06_Empty_To_Date(){
        customisedStatementPage.enterToFieldNameByName("", "tdate");
        customisedStatementPage.clickToSubmitButton();
        customisedStatementPage.clickOnOKAlert();

        Assert.assertEquals(customisedStatementPage.getErrorMessage("tdate"), "To Date Field must not be blank");

    }

    @Test
    public void Delete_Customer_07_Not_Number_Minimum(){
        customisedStatementPage.enterToFieldNameByName("abc", "amountlowerlimit");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("amountlowerlimit"), "Characters are not allowed");

    }

    @Test
    public void Delete_Customer_08_Special_Minimum(){
        customisedStatementPage.enterToFieldNameByName("@", "amountlowerlimit");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("amountlowerlimit"), "Special characters are not allowed");

    }

    @Test
    public void Delete_Customer_09_Blank_Minimum(){
        customisedStatementPage.enterToFieldNameByName(" ", "amountlowerlimit");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("amountlowerlimit"), "Characters are not allowed");

    }

    @Test
    public void Delete_Customer_10_Not_Number_Number(){
        customisedStatementPage.enterToFieldNameByName("abc", "numtransaction");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("numtransaction"), "Characters are not allowed");

    }

    @Test
    public void Delete_Customer_11_Special_Number(){
        customisedStatementPage.enterToFieldNameByName("@", "numtransaction");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("numtransaction"), "Special characters are not allowed");

    }

    @Test
    public void Delete_Customer_12_Blank_Number(){
        customisedStatementPage.enterToFieldNameByName(" ", "numtransaction");

        Assert.assertEquals(customisedStatementPage.getErrorMessage("numtransaction"), "Characters are not allowed");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
