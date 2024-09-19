package pageObjects;

import pageUIs.MiniStatementPageUI;
import org.openqa.selenium.WebDriver;

public class MiniStatementPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public MiniStatementPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToAccountNoTextbox(String value) {
        waitForAllElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
        sendKeyToElement(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, MiniStatementPageUI.ACCOUNT_SUBMIT_BUTTON);
        clickToElement(driver, MiniStatementPageUI.ACCOUNT_SUBMIT_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, MiniStatementPageUI.ERROR_MESSAGE);
        return getElementText(driver, MiniStatementPageUI.ERROR_MESSAGE);
    }
}
