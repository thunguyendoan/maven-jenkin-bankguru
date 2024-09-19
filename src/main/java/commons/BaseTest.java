package commons;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest extends BasePage {
    private WebDriver driver;
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;

    protected WebDriver OpenMultipleBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case CHROME:
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser Name is not valid");
        }

        driver.manage().window().setPosition(new Point(0 , 0));
        driver.manage().window().setSize(new Dimension(1300, 1090));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        return driver;
    }

    protected WebDriver OpenMultipleBrowserDriver(String browserName, String url){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case CHROME:
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser Name is not valid");
        }

        driver.manage().window().setPosition(new Point(0 , 0));
        driver.manage().window().setSize(new Dimension(1300, 1090));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));

        driver.get(url);
        return driver;
    }
}
