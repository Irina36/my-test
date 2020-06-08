package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    By demo = By.xpath("//*[@id=\"sidebar\"]/div/ul/li[3]/a");
    By bankDetail = By.xpath("//*[@id=\"sidebar\"]/div/ul/li[4]/a");

    public void demoPage() throws InterruptedException {
        Thread.sleep(2000);
        click(demo);

    }
    public void bankDetail() throws InterruptedException {
        Thread.sleep(2000);
        click(bankDetail);
    }
}
