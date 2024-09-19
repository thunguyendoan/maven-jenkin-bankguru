package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.NewAccountPageObject;

public class New_Account_Login extends BaseTest {
    private WebDriver driver;
    private NewAccountPageObject newAccountPage;
    private String emailAddress = getRandomEmail();
    public static String userID, password;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = OpenMultipleBrowserDriver(browserName);
        openURL(driver,"https://demo.guru99.com/");
        newAccountPage = PageGeneraterManager.getNewAccountPage(driver);
    }

    @Test
    public void New_Account_01_Empty(){
        newAccountPage.enterEmail("");
        newAccountPage.clickToSubmitButton();

        Assert.assertEquals(newAccountPage.getMessage(), "Email ID must not be blank");
    }

    @Test
    public void New_Account_02_Not_Numberic(){
        newAccountPage.enterEmail("abc");
        newAccountPage.clickToSubmitButton();

        Assert.assertEquals(newAccountPage.getMessage(), "Email ID is not valid");
    }

    @Test
    public void New_Account_03_Special_Character(){
        newAccountPage.enterEmail("abc@");
        newAccountPage.clickToSubmitButton();

        Assert.assertEquals(newAccountPage.getMessage(), "Email ID is not valid");
    }

    @Test
    public void New_Account_04_Blank_Character(){
        newAccountPage.enterEmail("abc @noemail.com");
        newAccountPage.clickToSubmitButton();

        Assert.assertEquals(newAccountPage.getMessage(), "Email ID is not valid");

        newAccountPage.enterEmail(" abc@noemail.com");
        newAccountPage.clickToSubmitButton();

        Assert.assertEquals(newAccountPage.getMessage(), "Email ID is not valid");
    }

    @Test
    public void New_Account_05_Valid_Email(){
        newAccountPage.enterEmail(emailAddress);
        newAccountPage.clickToSubmitButton();

        userID = newAccountPage.getRowByText("User ID");
        password = newAccountPage.getRowByText("Password");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
