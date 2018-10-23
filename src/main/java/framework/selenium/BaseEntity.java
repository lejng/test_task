package framework.selenium;

import framework.selenium.drivers.Browser;
import framework.utils.PropertyHelper;
import framework.utils.LoggerHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity {
    protected final LoggerHelper loggerHelper = LoggerHelper.getInstance();
    protected static Browser browser;
    protected static WebDriver driver;

    @BeforeClass
    public void before() {
        browser = Browser.getInstance();
        driver = browser.getDriver();
        browser.maximizeWindow();
        browser.navigateToUrl(PropertyHelper.getProperty(PropertyHelper.BASE_URL));
    }

    @AfterClass
    public void after() {
        browser.close();
    }
}
