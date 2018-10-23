package framework.utils;

import framework.selenium.drivers.BrowserType;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHelper {
    public static final String TIMEOUT_LOAD_PAGE_SCRIPT = "timeout.load.pages.scripts";
    public static final String IMPLICITLY_WAIT = "timeout.implicitly.wait";
    public static final String BASE_URL = "site.url";

    private static final String CURRENT_BROWSER = "current.browser.class";
    private static final String PROPERTY_PATH = "src/main/resources/config.properties";
    private static final LoggerHelper log = LoggerHelper.getInstance();

    public static String getProperty(String name){
        try(FileInputStream fis = new FileInputStream(PROPERTY_PATH)){
            Properties property = new Properties();
            property.load(fis);
            return property.getProperty(name);
        }catch (Exception e){
            log.error("error read property");
        }
        return null;
    }

    public static int getIntProperty(String name){
        return Integer.parseInt(getProperty(name));
    }

    public static BrowserType getBrowser(){
        return BrowserType.valueOf(getProperty(CURRENT_BROWSER));
    }
}
