package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
public class BasePage {

    public void openURL(WebDriver driver, String URL){
        driver.get(URL);
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        waitAlertPresence(driver).accept();
    }

    public String getTextAlert(WebDriver driver){
        return waitAlertPresence(driver).getText();
    }

    public By getByLocator(String locatorType){
        By by = null;
        if (locatorType.startsWith("id") || locatorType.startsWith("ID") || locatorType.startsWith("Id")){
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class") || locatorType.startsWith("CLASS") || locatorType.startsWith("Class")){
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name") || locatorType.startsWith("NAME") || locatorType.startsWith("Name")){
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css") || locatorType.startsWith("CSS") || locatorType.startsWith("Css")){
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath")){
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported!");
        }
        return by;
    }

    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public String getDynamicLocator(String locator, String... restParams){
        return String.format(locator, (Object[]) restParams);
    }

    public WebElement getWebElement(WebDriver driver, String locator){
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListWebElements(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator){
        getWebElement(driver,locator).click();
    }

    public void clickToElement(WebDriver driver, WebElement element){
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParams){
        getWebElement(driver,getDynamicLocator(locator, restParams)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend){
        getWebElement(driver, locator).clear();
        getWebElement(driver,locator).sendKeys(keyToSend);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend, String... restParams){
        getWebElement(driver, getDynamicLocator(locator, restParams)).clear();
        getWebElement(driver,getDynamicLocator(locator, restParams)).sendKeys(keyToSend);
    }

    public void selectItemDefaultDropdown(WebDriver driver, String locator, String itemValue){
        new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
    }


    public String getElementAttributeValue(WebDriver driver, String locator, String attributeName){
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttributeValue(WebDriver driver, String locator, String attributeName, String... restParams){
        return getWebElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator){
        return getWebElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParams){
        return getWebElement(driver, getDynamicLocator(locator, restParams)).getText();
    }

    public String getElementCssValue(WebDriver driver, String locator, String propertyName){
        return getWebElement(driver, locator).getCssValue(propertyName);
    }


    public void setImplicitWait(WebDriver driver, long timeout){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParams){
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForAllElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElements(getListWebElements(driver, locator)));
    }


    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParams){
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public String getRandomEmail(){
        Random random = new Random();
        return "trungthu" + random.nextInt(999) + "@noemail.com";
    }


    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
}
