package pageObjects;

import pageUIs.DeleteAccountPageUI;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public DeleteAccountPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void inputToAccountNoTextbox(String value) {
        waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX);
        sendKeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX, value);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
        clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, DeleteAccountPageUI.ERROR_MESSAGE);
        return getElementText(driver, DeleteAccountPageUI.ERROR_MESSAGE);
    }
}
