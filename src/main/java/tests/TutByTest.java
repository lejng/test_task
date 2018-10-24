package tests;

import framework.BaseTest;
import framework.CustomAssert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import tests.enums.ProfileMenuItems;
import tests.pages.MailInboxMessagesPage;
import tests.pages.MainPage;

public class TutByTest extends BaseTest {
    private String login;
    private String password;
    private int expectedCountMessages;

    @Parameters(value = {"login", "password", "expectedCountMessages"})
    public TutByTest(@Optional String login, @Optional String password, @Optional int expectedCountMessages){
        this.login = login;
        this.password = password;
        this.expectedCountMessages = expectedCountMessages;
    }

    @Override
    public void runTest() {
        int step = 1;

        loggerHelper.logStep("Open site tut.by", step++);
        MainPage mainPage = new MainPage();

        loggerHelper.logStep("Login on site tut.by", step++);
        mainPage.openLoginForm();
        CustomAssert.assertTrue(mainPage.isLoginFormOpened(), "Login form is not open");
        mainPage.login(login, password);
        CustomAssert.assertTrue(mainPage.isLogin(), "Error login to the site");

        loggerHelper.logStep("Open profile menu item 'Mail'", step++);
        mainPage.chooseProfileMenuItem(ProfileMenuItems.MAIL);

        loggerHelper.logStep("Check count inbox messages", step++);
        browser.switchToNewTab();
        MailInboxMessagesPage mailInboxMessagesPage = new MailInboxMessagesPage();
        int actualCountMessages = mailInboxMessagesPage.getMessageCount();
        CustomAssert.assertEquals(actualCountMessages, expectedCountMessages, "Wrong count input messages");
    }
}
