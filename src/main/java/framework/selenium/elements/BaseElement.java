package framework.selenium.elements;

import framework.selenium.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement extends BaseEntity {
    protected By locator;
    protected String name;

    public BaseElement(By locator, String name){
        this.locator = locator;
        this.name = name;
    }

    protected abstract String getElementType();

    protected WebElement getElement(){
        return driver.findElement(locator);
    }

    public boolean isElementExist(){
        if(driver.findElements(locator).size() > 0){
            return true;
        }
        try {
            driver.findElement(locator);
        }catch (Exception e){
            loggerHelper.error(String.format("Element %s '%s' :: is not found: %s", getElementType(), name, e.getStackTrace()));
            return false;
        }
        return true;
    }

    public void click(){
        loggerHelper.info(String.format("Element %s '%s' :: clicking...", getElementType(), name));
        getElement().click();
    }

    public String getText(){
        loggerHelper.info(String.format("Element %s '%s' :: getting text...", getElementType(), name));
        return getElement().getText();
    }

    public String getAttribute(String attribute){
        loggerHelper.info(String.format("Element %s '%s' :: getting attribute '%s' ...", getElementType(), name, attribute));
        return getElement().getAttribute(attribute);
    }

    public boolean isEnable(){
        return getElement().isEnabled();
    }

    public boolean isDisplayed(){
        return getElement().isDisplayed();
    }

    public boolean isSelected(){
        return getElement().isSelected();
    }
}
