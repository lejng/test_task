package tests.pages;

import framework.selenium.BasePage;
import framework.selenium.elements.Label;
import framework.utils.StringUtils;
import org.openqa.selenium.By;

public class MailInboxMessagesPage extends BasePage {
    private static By uniqueLocator =
            By.xpath("//a[contains(@class,'mail-NestedList-Item_current')]//span[contains(text(),'Входящие')]");
    private Label messagesCountLabel =
            new Label(By.xpath("//a[contains(@title,'Входящие')]//span[contains(@class,'Extras')]"), "Messages count");

    public MailInboxMessagesPage() {
        super(uniqueLocator, "Mail Inbox Messages");
    }

    public int getMessageCount(){
        return Integer.parseInt(StringUtils.replaceAllSlashAndTrim(messagesCountLabel.getText()));
    }
}
