package pageObjects;

import pageUIs.HomePageNewAccountPageUI;
import org.openqa.selenium.WebDriver;

public class HomePageNewAccountPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public HomePageNewAccountPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void inputToFieldNameByName(String valueToSend, String fieldName) {
        waitForElementVisible(driver, HomePageNewAccountPageUI.DYNAMIC_FIELD_NAME_BY_NAME, fieldName);
        sendKeyToElement(driver, HomePageNewAccountPageUI.DYNAMIC_FIELD_NAME_BY_NAME,valueToSend, fieldName);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, HomePageNewAccountPageUI.SUBMIT_BUTTON);
        clickToElement(driver, HomePageNewAccountPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessageByName(String fieldName) {
        waitForElementVisible(driver, HomePageNewAccountPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
        return getElementText(driver, HomePageNewAccountPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
    }


    public void inputToAccountTypeDropdown(String itemValue) {
        waitForElementClickable(driver, HomePageNewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
        selectItemDefaultDropdown(driver, HomePageNewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, itemValue);
    }

    public String getMessageSuccess() {
        waitForElementVisible(driver, HomePageNewAccountPageUI.MESSAGE_SUCCESS);
        return getElementText(driver, HomePageNewAccountPageUI.MESSAGE_SUCCESS);
    }

    public String getTextByRowName(String rowName) {
        waitForElementVisible(driver, HomePageNewAccountPageUI.DYNAMIC_TEXT_BY_ROW_NAME, rowName);
        return getElementText(driver, HomePageNewAccountPageUI.DYNAMIC_TEXT_BY_ROW_NAME, rowName);
    }

    public void refreshPage() {
        refreshCurrentPage(driver);
    }

    public void clickToOKOnAlert() {
        acceptAlert(driver);
    }
}
