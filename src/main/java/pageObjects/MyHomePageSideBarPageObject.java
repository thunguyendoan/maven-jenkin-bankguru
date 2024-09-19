package pageObjects;

import pageUIs.MyHomePageSideBarPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyHomePageSideBarPageObject extends BasePage {
    WebDriver driver;

    public MyHomePageSideBarPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void openDynamicSideBarByPageName(String pageName){
        waitForElementClickable(driver, MyHomePageSideBarPageUI.DYNAMIC_SIDE_BAR_LINK_TEXT, pageName);
        clickToElement(driver, MyHomePageSideBarPageUI.DYNAMIC_SIDE_BAR_LINK_TEXT, pageName);
    }
}
