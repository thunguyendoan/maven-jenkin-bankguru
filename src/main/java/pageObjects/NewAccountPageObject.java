package pageObjects;

import pageUIs.NewAccountPageUI;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;

public class NewAccountPageObject extends BaseTest {
    WebDriver driver;

    public NewAccountPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String emailAddress) {
        waitForElementVisible(driver, NewAccountPageUI.EMAILID_TEXTBOX);
        sendKeyToElement(driver, NewAccountPageUI.EMAILID_TEXTBOX, emailAddress);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, NewAccountPageUI.SUBMIT_BUTTON);
        clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
    }

    public String getMessage() {
        waitForElementVisible(driver, NewAccountPageUI.ERROR_MESSAGE);
        return getElementText(driver, NewAccountPageUI.ERROR_MESSAGE);
    }

    public String getRowByText(String rowName) {
        waitForElementVisible(driver, NewAccountPageUI.DYNAMIC_TEXTBOX_NEW_ACCOUNT, rowName);
        return getElementText(driver, NewAccountPageUI.DYNAMIC_TEXTBOX_NEW_ACCOUNT, rowName);
    }

}
