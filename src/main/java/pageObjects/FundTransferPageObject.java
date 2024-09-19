package pageObjects;

import pageUIs.FundTransferPageUI;
import org.openqa.selenium.WebDriver;

public class FundTransferPageObject extends MyHomePageSideBarPageObject {
    WebDriver driver;

    public FundTransferPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void inputToFieldNameByName(String valueToSend, String fieldName) {
        waitForElementVisible(driver, FundTransferPageUI.DYNAMIC_FIELD_NAMEBY_NAME, fieldName);
        sendKeyToElement(driver, FundTransferPageUI.DYNAMIC_FIELD_NAMEBY_NAME, valueToSend, fieldName);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, FundTransferPageUI.SUBMIT_BUTTON);
        clickToElement(driver, FundTransferPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessage(String fieldName) {
        waitForElementVisible(driver, FundTransferPageUI.ERROR_MESSAGE_BY_NAME, fieldName);
        return getElementText(driver, FundTransferPageUI.ERROR_MESSAGE_BY_NAME, fieldName);
    }

    public void clickToOKOnAlert() {
        acceptAlert(driver);
    }
}
