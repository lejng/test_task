package tests.pages;

import framework.selenium.BasePage;
import framework.selenium.elements.Button;
import org.openqa.selenium.By;
import tests.enums.ProfileMenuItems;
import tests.forms.LoginForm;
import tests.menus.ProfileMenu;

public class MainPage extends BasePage {
    private static By uniqueLocator = By.id("title_news_block");
    private Button loginButton = new Button(By.xpath("//*[@id='authorize']//a[contains(text(),'Войти')]"), "Login");
    private ProfileMenu profileMenu = new ProfileMenu();
    private LoginForm loginForm = new LoginForm();

    public MainPage() {
        super(uniqueLocator, "Main Tut By");
    }

    public void openLoginForm(){
        loginButton.click();
    }

    public void chooseProfileMenuItem(ProfileMenuItems item){
        profileMenu.chooseMenuItem(item);
    }

    public void login(String login, String password){
        loginForm.login(login, password);
    }

    public boolean isLoginFormOpened(){
        return loginForm.isOpened();
    }

    public boolean isLogin(){
        return profileMenu.isLogin();
    }
}
