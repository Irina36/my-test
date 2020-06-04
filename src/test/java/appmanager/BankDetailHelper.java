package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankDetailHelper extends HelperBase {
    public BankDetailHelper(WebDriver driver) {
        super(driver);
    }
    By rub = By.xpath("//*[@id=\"content\"]/div[2]/a[1]");
}
