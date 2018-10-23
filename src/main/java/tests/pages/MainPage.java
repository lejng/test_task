package tests.pages;

import framework.selenium.BasePage;
import framework.selenium.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static By uniqueLocator = By.id("title_news_block");
    private Button loginButton = new Button(By.xpath("//*[@id='authorize']//a[contains(text(),'Войти')]"), "Login");

    public MainPage() {
        super(uniqueLocator, "Main Tut By");
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
