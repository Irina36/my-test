package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoDemoPage() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("//*[@id=\"sidebar\"]/div/ul/li[3]/a"));

    }
    public void gotoMyBankDetail() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("//*[@id=\"sidebar\"]/div/ul/li[4]/a"));
    }
}
