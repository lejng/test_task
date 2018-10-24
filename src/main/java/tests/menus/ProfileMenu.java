package tests.menus;

import framework.selenium.elements.Label;
import org.openqa.selenium.By;
import tests.enums.ProfileMenuItems;

public class ProfileMenu {
    private Label usernameLabel = new Label(By.xpath("//span[contains(@class,'uname')]"), "Username");
    private static String menuItemTemplate = "//div[contains(@class,'logedin')]//a[contains(text(),'%s')]";

    public void chooseMenuItem(ProfileMenuItems item){
        usernameLabel.click();
        By itemXpath = By.xpath(String.format(menuItemTemplate, item.getValue()));
        new Label(itemXpath, item.getValue()).click();
    }

    public boolean isLogin(){
        return usernameLabel.isElementExist();
    }
}
