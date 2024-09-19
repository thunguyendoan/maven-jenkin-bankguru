package pageObjects;

import pageUIs.EditCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class EditCustomerPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public EditCustomerPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterToCustomerIDTextbox(String value) {
        waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
        sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, value);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, EditCustomerPageUI.SUBMIT_BUTTON);
        clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, EditCustomerPageUI.ERROR_MESSAGE);
        return getElementText(driver, EditCustomerPageUI.ERROR_MESSAGE);
    }

    public void inputToAddressTextarea(String value) {
        waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
        sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, value);
    }

    public void inputToTextboxByName(String valueToSend, String fieldName){
        waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_FIELD_NAME_BY_NAME, fieldName);
        sendKeyToElement(driver, EditCustomerPageUI.DYNAMIC_FIELD_NAME_BY_NAME, valueToSend, fieldName);
    }

    public void clickToOKOnAlert() {
        acceptAlert(driver);
    }

    public String getAddressText() {
        waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
        return getElementText(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
    }

    public String getAttributeValueByName(String fieldName) {
        waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_FIELD_NAME_BY_NAME, fieldName);
        return getElementAttributeValue(driver, EditCustomerPageUI.DYNAMIC_FIELD_NAME_BY_NAME, "value", fieldName);
    }
}
