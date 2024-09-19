package pageObjects;

import pageUIs.EditAccountPageUI;
import org.openqa.selenium.WebDriver;

public class EditAccountPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public EditAccountPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void inputToAccountNoTextbox(String value) {
        waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NO_TEXTBOX);
        sendKeyToElement(driver, EditAccountPageUI.ACCOUNT_NO_TEXTBOX, value);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, EditAccountPageUI.SUBMIT_BUTTON);
        clickToElement(driver, EditAccountPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, EditAccountPageUI.ERROR_MESSAGE);
        return getElementText(driver, EditAccountPageUI.ERROR_MESSAGE);
    }
}
