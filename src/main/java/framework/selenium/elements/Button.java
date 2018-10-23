package framework.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Button extends BaseElement {

    public Button(By locator, String name) {
        super(locator, name);
    }

    @Override
    protected String getElementType() {
        return "Button";
    }
}
