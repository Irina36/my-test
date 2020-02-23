package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {

        super(driver);
    }
    public void login(String username, String password)  {

        typeText(By.xpath("//form[@id='form-login']//input[@name='_username']"),username);
        typeText(By.xpath("//form[@id='form-login']//input[@name='_password']"),password);
        click(By.xpath("//form[@id='form-login']//input[@type='submit']"));

    }
}
