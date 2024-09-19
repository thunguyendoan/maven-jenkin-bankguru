package pageObjects;

import pageUIs.WithdrawalPageUI;
import org.openqa.selenium.WebDriver;

public class WithdrawalPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public WithdrawalPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void inputToDynamicFieldByName(String valueToSend, String fieldName) {
        waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX_BY_NAME, fieldName);
        sendKeyToElement(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX_BY_NAME, valueToSend, fieldName);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, WithdrawalPageUI.SUBMIT_BUTTON);
        clickToElement(driver, WithdrawalPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessageByName(String fieldName) {
        waitForElementVisible(driver, WithdrawalPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
        return getElementText(driver, WithdrawalPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
    }

    public void clickToOKOnAlert() {
        acceptAlert(driver);
    }
}
