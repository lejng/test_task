package tests;

import framework.BaseTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import tests.forms.LoginForm;
import tests.pages.MainPage;

public class TutByTest extends BaseTest {
    private String login;
    private String password;

    @Parameters(value = {"login", "password"})
    public TutByTest(@Optional String login, @Optional String password){
        this.login = login;
        this.password = password;
    }

    @Override
    public void runTest() {
        int step = 1;

        loggerHelper.logStep("Open site tut.by", step++);
        MainPage mainPage = new MainPage();
        mainPage.clickLoginButton();

        loggerHelper.logStep("Login on site tut.by", step++);
        LoginForm loginForm = new LoginForm();
        loginForm.login(login, password);
    }
}
