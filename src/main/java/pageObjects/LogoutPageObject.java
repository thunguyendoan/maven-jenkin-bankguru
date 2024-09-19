package pageObjects;

import org.openqa.selenium.WebDriver;

public class LogoutPageObject extends MyHomePageSideBarPageObject{
    WebDriver driver;

    public LogoutPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String getTextOnAlert() {
        waitAlertPresence(driver);
        return getTextAlert(driver);
    }

    public void clickOKOnAlert() {
        acceptAlert(driver);
    }
}
