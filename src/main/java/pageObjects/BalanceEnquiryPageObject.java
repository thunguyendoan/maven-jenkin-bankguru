package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.BalanceEnquiryPageUI;

public class BalanceEnquiryPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public BalanceEnquiryPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void inputToAccountNoTextbox(String value) {
        waitForElementVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX);
        sendKeyToElement(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX, value);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
        clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, BalanceEnquiryPageUI.ERROR_MESSAGE);
        return getElementText(driver, BalanceEnquiryPageUI.ERROR_MESSAGE);
    }
}
