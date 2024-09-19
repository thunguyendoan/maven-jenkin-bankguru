package pageObjects;

import pageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends MyHomePageSideBarPageObject {
    WebDriver driver;

    public HomePageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterToUserIDTextbox(String userID) {
        waitForElementVisible(driver, HomePageUI.USER_ID_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.USER_ID_TEXTBOX, userID);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, HomePageUI.LOGIN_BUTTON);
        clickToElement(driver, HomePageUI.LOGIN_BUTTON);
    }

    public String getMangerID() {
        waitForElementVisible(driver, HomePageUI.MANGER_ID_TEXT);
        return getElementText(driver, HomePageUI.MANGER_ID_TEXT);
    }

    public String getTextOnAlert() {
        waitAlertPresence(driver);
        return getTextAlert(driver);
    }
}
