package tests.forms;

import framework.selenium.BasePage;
import framework.selenium.elements.Button;
import framework.selenium.elements.Input;
import org.openqa.selenium.By;

public class LoginForm extends BasePage {
    private static By uniqueLocator = By.xpath("//*[@id='authorize']//form");
    private Input loginInput = new Input(By.xpath("//*[@id='authorize']//input[@name='login']"), "Login");
    private Input passwordInput = new Input(By.xpath("//*[@id='authorize']//input[@name='password']"), "Password");
    private Button loginButton = new Button(By.xpath("//*[@id='authorize']//input[contains(@value,'Войти')]"), "Login");

    public LoginForm(){
        super(uniqueLocator, "Login form");
    }

    public void login(String login, String password){
        loginInput.setText(login);
        passwordInput.setText(password);
        loginButton.click();
    }
}
