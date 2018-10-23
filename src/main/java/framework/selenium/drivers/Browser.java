package framework.selenium.drivers;

import framework.utils.PropertyHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static Browser instance;
    private static WebDriver driver;
    private static final String ERROR = "No browser selected";

    public static synchronized Browser getInstance(){
        return instance != null ? instance : (instance = new Browser());
    }

    private Browser(){
        driver = createDriver();
        driver.manage().timeouts()
                .implicitlyWait(PropertyHelper.getIntProperty(PropertyHelper.IMPLICITLY_WAIT), TimeUnit.SECONDS);
    }

    private static WebDriver createDriver(){
        switch (PropertyHelper.getBrowser()){
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalStateException(ERROR);
        }
    }

    private static ChromeDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static FirefoxDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url){
        driver.navigate().to(url);
    }

    public void close(){
        driver.quit();
    }
}
