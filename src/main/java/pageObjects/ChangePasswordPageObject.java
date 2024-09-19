package pageObjects;

import pageUIs.ChangePasswordPageUI;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void inputToFieldNameByName(String valueToSend, String fieldName) {
        waitForElementVisible(driver, ChangePasswordPageUI.DYNAMIC_FIELD_NAME_BY_NAME, fieldName);
        sendKeyToElement(driver, ChangePasswordPageUI.DYNAMIC_FIELD_NAME_BY_NAME,valueToSend, fieldName);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, ChangePasswordPageUI.SUBMIT_BUTTON);
        clickToElement(driver, ChangePasswordPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessageByName(String fieldName) {
        waitForElementVisible(driver, ChangePasswordPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
        return getElementText(driver, ChangePasswordPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
    }


    public void clickToOKOnAlert() {
        acceptAlert(driver);
    }

    public String getTextOnAlert() {
        waitAlertPresence(driver);
        return getTextAlert(driver);
    }
}
