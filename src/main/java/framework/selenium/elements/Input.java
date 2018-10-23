package framework.selenium.elements;

import org.openqa.selenium.By;

public class Input extends BaseElement {

    public Input(By locator, String name){
        super(locator, name);
    }

    @Override
    protected String getElementType() {
        return "Input";
    }

    public void setText(String text){
        loggerHelper.info(String.format("Element %s '%s' :: setting text: '%s'", getElementType(), name, text));
        getElement().sendKeys(text);
    }
}
