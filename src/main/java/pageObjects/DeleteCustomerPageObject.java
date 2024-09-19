package pageObjects;

import pageUIs.DeleteCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public DeleteCustomerPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterToCustomerIDTextbox(String value) {
        waitForAllElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
        sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, value);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, DeleteCustomerPageUI.ERROR_MESSAGE);
        return getElementText(driver, DeleteCustomerPageUI.ERROR_MESSAGE);
    }

    public void clickToSubmitButton() {
        waitForElementClickable(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
        clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
    }
}
