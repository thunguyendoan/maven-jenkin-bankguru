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
import pageObjects.NewCustomerPageObject;

public class Home_Page_New_Customer extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private NewCustomerPageObject newCustomerPage;
    private String emailAddress = getRandomEmail();
    public static String customerID;
    public static String customerName = "trung thu";


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

        homePage.openDynamicSideBarByPageName("New Customer");
        newCustomerPage = PageGeneraterManager.getNewCustomerPage(driver);
    }

    @Test
    public void New_Customer_01_Empty_Name(){
        newCustomerPage.inputToFieldNameByName("", "name");
        newCustomerPage.clickToSubmitButton();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("name"), "Customer name must not be blank");

    }

    @Test
    public void New_Customer_02_Number_Name(){
        newCustomerPage.inputToFieldNameByName("123", "name");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("name"), "Numbers are not allowed");

    }

    @Test
    public void New_Customer_03_SpecialCharacter_Name(){
        newCustomerPage.inputToFieldNameByName("@", "name");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("name"), "Special characters are not allowed");

    }

    @Test
    public void New_Customer_03_First_Character_Blank_Name(){
        newCustomerPage.inputToFieldNameByName(" ", "name");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("name"), "First character can not have space");

    }

    @Test
    public void New_Customer_04_Empty_DOB(){
        newCustomerPage.inputToFieldNameByName("", "dob");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("dob"), "Date Field must not be blank");

    }

    @Test
    public void New_Customer_05_Empty_Addr(){
        newCustomerPage.inputToAddressTextarea("");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getAddressErrorMessage(), "Address Field must not be blank");
    }

    @Test
    public void New_Customer_06_SpecialChar_Addr(){
        newCustomerPage.inputToAddressTextarea("@");

        Assert.assertEquals(newCustomerPage.getAddressErrorMessage(), "Special characters are not allowed");
    }

    @Test
    public void New_Customer_07_First_Char_Blank_Addr(){
        newCustomerPage.inputToAddressTextarea(" ");

        Assert.assertEquals(newCustomerPage.getAddressErrorMessage(), "First character can not have space");
    }

    @Test
    public void New_Customer_08_Empty_City(){
        newCustomerPage.inputToFieldNameByName("", "city");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("city"), "City Field must not be blank");

    }

    @Test
    public void New_Customer_09_Number_City(){
        newCustomerPage.inputToFieldNameByName("123", "city");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("city"), "Numbers are not allowed");

    }

    @Test
    public void New_Customer_10_SpecialChar_City(){
        newCustomerPage.inputToFieldNameByName("@", "city");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("city"), "Special characters are not allowed");

    }

    @Test
    public void New_Customer_11_First_Char_Blank_City(){
        newCustomerPage.inputToFieldNameByName(" ", "city");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("city"), "First character can not have space");

    }

    @Test
    public void New_Customer_12_Empty_State(){
        newCustomerPage.inputToFieldNameByName("", "state");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("state"), "State must not be blank");

    }

    @Test
    public void New_Customer_13_Number_State(){
        newCustomerPage.inputToFieldNameByName("123", "state");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("state"), "Numbers are not allowed");

    }

    @Test
    public void New_Customer_14_SpecialChar_State(){
        newCustomerPage.inputToFieldNameByName("@", "state");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("state"), "Special characters are not allowed");

    }

    @Test
    public void New_Customer_15_First_Char_Blank_State(){
        newCustomerPage.inputToFieldNameByName(" ", "state");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("state"), "First character can not have space");

    }

    @Test
    public void New_Customer_16_Empty_PIN(){
        newCustomerPage.inputToFieldNameByName("", "pinno");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("pinno"), "PIN Code must not be blank");

    }

    @Test
    public void New_Customer_17_Less_6Chars_PIN(){
        newCustomerPage.inputToFieldNameByName("123", "pinno");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("pinno"), "PIN Code must have 6 Digits");

    }

    @Test
    public void New_Customer_18_Not_Number_PIN(){
        newCustomerPage.inputToFieldNameByName("abc", "pinno");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("pinno"), "Characters are not allowed");

    }

    @Test
    public void New_Customer_18_Special_Char_PIN(){
        newCustomerPage.inputToFieldNameByName("@", "pinno");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("pinno"), "Special characters are not allowed");

    }

    @Test
    public void New_Customer_19_Empty_Mobile(){
        newCustomerPage.inputToFieldNameByName("", "telephoneno");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("telephoneno"), "Mobile no must not be blank");

    }

    @Test
    public void New_Customer_20_Not_Number_Mobile(){
        newCustomerPage.inputToFieldNameByName("abc", "telephoneno");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("telephoneno"), "Characters are not allowed");

    }

    @Test
    public void New_Customer_21_Special_Char_Mobile(){
        newCustomerPage.inputToFieldNameByName("@", "telephoneno");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("telephoneno"), "Special characters are not allowed");

    }

    @Test
    public void New_Customer_22_First_Char_Blank_Mobile(){
        newCustomerPage.inputToFieldNameByName(" ", "telephoneno");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("telephoneno"), "First character can not have space");

    }

    @Test
    public void New_Customer_23_Empty_Email(){
        newCustomerPage.inputToFieldNameByName("", "emailid");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("emailid"), "Email-ID must not be blank");

    }

    @Test
    public void New_Customer_24_Invalid_Email(){
        newCustomerPage.inputToFieldNameByName("11", "emailid");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("emailid"), "Email-ID is not valid");

    }

    @Test
    public void New_Customer_25_First_Char_Blank_Email(){
        newCustomerPage.inputToFieldNameByName(" ", "emailid");

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("emailid"), "First character can not have space");

    }

    @Test
    public void New_Customer_26_Empty_Password(){
        newCustomerPage.inputToFieldNameByName("", "password");
        newCustomerPage.clickToSubmitButton();
        newCustomerPage.clickToOKOnAlert();

        Assert.assertEquals(newCustomerPage.getErrorMessageByName("password"), "Password must not be blank");

    }

    @Test
    public void New_Customer_27_New_Account_Successfully(){
        newCustomerPage.refreshPage();
        newCustomerPage.inputToFieldNameByName(customerName, "name");
        newCustomerPage.clickToGenderRadio("f");
        newCustomerPage.inputToFieldNameByName("27031997", "dob");
        newCustomerPage.inputToAddressTextarea("nguyen trai");
        newCustomerPage.inputToFieldNameByName("ho chi minh", "city");
        newCustomerPage.inputToFieldNameByName("Dis ten", "state");
        newCustomerPage.inputToFieldNameByName("123456", "pinno");
        newCustomerPage.inputToFieldNameByName("11", "telephoneno");
        newCustomerPage.inputToFieldNameByName(emailAddress, "emailid");
        newCustomerPage.inputToFieldNameByName("123456", "password");

        newCustomerPage.clickToSubmitButton();

        Assert.assertEquals(newCustomerPage.getSuccessMessage(), "Customer Registered Successfully!!!");

        Assert.assertEquals(newCustomerPage.getValueByRowName("Customer Name"), customerName);
        Assert.assertEquals(newCustomerPage.getValueByRowName("Gender"), "female");
        Assert.assertEquals(newCustomerPage.getValueByRowName("Birthdate"), "1997-03-27");
        Assert.assertEquals(newCustomerPage.getValueByRowName("Address"), "nguyen trai");
        Assert.assertEquals(newCustomerPage.getValueByRowName("City"), "ho chi minh");
        Assert.assertEquals(newCustomerPage.getValueByRowName("State"), "Dis ten");
        Assert.assertEquals(newCustomerPage.getValueByRowName("Pin"), "123456");
        Assert.assertEquals(newCustomerPage.getValueByRowName("Mobile No."), "11");
        Assert.assertEquals(newCustomerPage.getValueByRowName("Email"), emailAddress);

        customerID = newCustomerPage.getValueByRowName("Customer ID");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
