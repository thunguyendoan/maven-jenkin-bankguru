package pageObjects;

import pageUIs.NewCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class NewCustomerPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public NewCustomerPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void inputToFieldNameByName(String valueToSend, String fieldName) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_FIELD_NAME_BY_NAME, fieldName);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_FIELD_NAME_BY_NAME,valueToSend, fieldName);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, NewCustomerPageUI.SUBMIT_BUTTON);
        clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessageByName(String fieldName) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
    }


    public void clickToOKOnAlert() {
        acceptAlert(driver);
    }

    public void inputToAddressTextarea(String value) {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
        sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, value);
    }

    public String getAddressErrorMessage() {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
    }

    public String getValueByRowName(String rowName) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_TEXT_BY_ROW_NAME, rowName);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_TEXT_BY_ROW_NAME, rowName);
    }

    public void clickToGenderRadio(String valueGender) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_GENDER_RADIO, valueGender);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_GENDER_RADIO, valueGender);
    }

    public void refreshPage() {
        refreshCurrentPage(driver);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, NewCustomerPageUI.MESSAGE_SUCCESS);
        return getElementText(driver, NewCustomerPageUI.MESSAGE_SUCCESS);
    }
}
