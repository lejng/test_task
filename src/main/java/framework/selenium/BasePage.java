package framework.selenium;

import framework.CustomAssert;
import framework.selenium.elements.Label;
import framework.utils.PropertyHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public abstract class BasePage extends BaseEntity {
    protected By uniqueLocator;
    protected String pageName;

    public BasePage(By uniqueLocator, String pageName){
        this.uniqueLocator = uniqueLocator;
        this.pageName = pageName;
        assertIsOpen();
    }

    public void assertIsOpen(){
        waitForLoadScripts();
        String name = String.format("Page %s", pageName);
        if(!new Label(uniqueLocator, name).isElementExist()){
            CustomAssert.assertFail(String.format("Page %s was not opened", pageName));
        }
    }

    public void waitForLoadScripts() {
        new WebDriverWait(driver, PropertyHelper.getIntProperty(PropertyHelper.TIMEOUT_LOAD_PAGE_SCRIPT))
                .until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState").equals("complete"));
    }
}
