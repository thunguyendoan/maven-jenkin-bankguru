package pageObjects;

import pageUIs.DepositPageUI;
import org.openqa.selenium.WebDriver;

public class DepositPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public DepositPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void inputToDynamicFieldByName(String valueToSend, String fieldName) {
        waitForElementVisible(driver, DepositPageUI.DYNAMIC_TEXTBOX_BY_NAME, fieldName);
        sendKeyToElement(driver, DepositPageUI.DYNAMIC_TEXTBOX_BY_NAME, valueToSend, fieldName);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, DepositPageUI.SUBMIT_BUTTON);
        clickToElement(driver, DepositPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessageByName(String fieldName) {
        waitForElementVisible(driver, DepositPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
        return getElementText(driver, DepositPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
    }

    public void clickToOKOnAlert() {
        acceptAlert(driver);
    }
}
