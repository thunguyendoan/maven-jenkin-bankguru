package com.bankguru.page;

import commons.BaseTest;
import commons.PageGeneraterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LogoutPageObject;

public class Home_Page_Change_Password extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private ChangePasswordPageObject changePasswordPage;
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

        homePage.openDynamicSideBarByPageName("Change Password");
        changePasswordPage = PageGeneraterManager.getChangePasswordPage(driver);

    }

    @Test
    public void Change_Password_01_Empty_Old_Pass(){
        changePasswordPage.inputToFieldNameByName("", "oldpassword");
        changePasswordPage.clickToSubmitButton();

        Assert.assertEquals(changePasswordPage.getErrorMessageByName("oldpassword"), "Old Password must not be blank");

    }

    @Test
    public void Change_Password_02_Empty_New_Pass(){
        changePasswordPage.inputToFieldNameByName("", "newpassword");
        changePasswordPage.clickToSubmitButton();
        changePasswordPage.clickToOKOnAlert();

        Assert.assertEquals(changePasswordPage.getErrorMessageByName("newpassword"), "New Password must not be blank");

    }

    @Test
    public void Change_Password_03_Not_Number_New_Pass(){
        changePasswordPage.inputToFieldNameByName("abc", "newpassword");

        Assert.assertEquals(changePasswordPage.getErrorMessageByName("newpassword"), "Enter at-least one numeric value");

    }

    @Test
    public void Change_Password_04_Only_Number_New_Pass(){
        changePasswordPage.inputToFieldNameByName("123", "newpassword");

        Assert.assertEquals(changePasswordPage.getErrorMessageByName("newpassword"), "Enter at-least one special character");

    }

    @Test
    public void Change_Password_05_Empty_Confirm_Pass(){
        changePasswordPage.inputToFieldNameByName("", "confirmpassword");
        changePasswordPage.clickToSubmitButton();
        changePasswordPage.clickToOKOnAlert();

        Assert.assertEquals(changePasswordPage.getErrorMessageByName("newpassword"), "Enter at-least one special character");

    }

    @Test
    public void Change_Password_06_Not_Match(){
        changePasswordPage.inputToFieldNameByName("abc123@", "newpassword");
        changePasswordPage.inputToFieldNameByName("abc", "confirmpassword");

        Assert.assertEquals(changePasswordPage.getErrorMessageByName("confirmpassword"), "Passwords do not Match");

    }

    @Test
    public void Change_Password_07_Success(){
        changePasswordPage.inputToFieldNameByName(New_Account_Login.password, "oldpassword");
        changePasswordPage.inputToFieldNameByName("Trungthu27@", "newpassword");
        changePasswordPage.inputToFieldNameByName("Trungthu27@", "confirmpassword");
        changePasswordPage.clickToSubmitButton();

        Assert.assertEquals(changePasswordPage.getTextOnAlert(), "Password is Changed");

        changePasswordPage.clickToOKOnAlert();

        homePage.enterToUserIDTextbox(New_Account_Login.userID);
        homePage.enterToPasswordTextbox("Trungthu27@");
        homePage.clickToLoginButton();

        Assert.assertEquals(homePage.getMangerID(),"Manger Id : " + New_Account_Login.userID);

    }

    @Test
    public void Change_Password_08_Login_Old_Pass(){
        homePage.openDynamicSideBarByPageName("Log out");
        logoutPage = PageGeneraterManager.getLogoutPage(driver);

        logoutPage.clickOKOnAlert();

        homePage.enterToUserIDTextbox(New_Account_Login.userID);
        homePage.enterToPasswordTextbox(New_Account_Login.password);
        homePage.clickToLoginButton();

        Assert.assertEquals(homePage.getTextOnAlert(), "User or Password is not valid");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
