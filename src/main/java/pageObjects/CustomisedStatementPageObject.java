package pageObjects;

import pageUIs.CustomisedStatementPageUI;
import org.openqa.selenium.WebDriver;

public class CustomisedStatementPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public CustomisedStatementPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterToFieldNameByName(String valueToSend, String fieldName) {
        waitForElementVisible(driver, CustomisedStatementPageUI.DYNAMIC_FIELD_NAME_BY_NAME, fieldName);
        sendKeyToElement(driver, CustomisedStatementPageUI.DYNAMIC_FIELD_NAME_BY_NAME,valueToSend, fieldName);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, CustomisedStatementPageUI.SUBMIT_BUTTON);
        clickToElement(driver, CustomisedStatementPageUI.SUBMIT_BUTTON);
    }

    public String getErrorMessage(String fieldName) {
        waitForElementVisible(driver, CustomisedStatementPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
        return getElementText(driver, CustomisedStatementPageUI.DYNAMIC_ERROR_MESSAGE_BY_NAME, fieldName);
    }

    public void clickOnOKAlert() {
        acceptAlert(driver);
    }
}
