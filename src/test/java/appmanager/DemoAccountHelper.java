package appmanager;

import model.DemoAccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoAccountHelper extends HelperBase {

    public DemoAccountHelper(WebDriver driver) {
        super(driver);
    }

    public void createDemoAccount() {
        click(By.xpath("//*[@id=\"content\"]/div[1]/a"));
    }

    public void fillDemoAccount(DemoAccountData demoAccountData) throws InterruptedException {

        click(By.xpath("//*[@id=\"select2-create_demo_account_account_type-container\"]"));

        switch (demoAccountData.getTypeAccount()) {
            case "2":
                click(By.xpath("//ul[@id=\"select2-create_demo_account_account_type-results\"]/li[1]"));
                break;
            case "3":
                click(By.xpath("//ul[@id=\"select2-create_demo_account_account_type-results\"]/li[2]"));
                break;
        }

        click(By.xpath("//*[@id=\"content\"]/form/div[2]/span/span[1]/span"));

        switch (demoAccountData.getCurrency()) {
            case "3":
                click(By.xpath("//ul[@id=\"select2-choice-currency-results\"]//li[text()='RUB']"));
                break;
            case "1":
                click(By.xpath("//ul[@id=\"select2-choice-currency-results\"]//li[text()='USD']"));
                break;
            case "2":
                click(By.xpath("//ul[@id=\"select2-choice-currency-results\"]//li[text()='EUR']"));
                break;
        }

        typeText(By.xpath("//*[@id=\"create_demo_account_balance\"]"), demoAccountData.getBalance());
    }

    public void submitDemoAccount() {
        click(By.xpath("//*[@id=\"create_demo_account_submit\"]"));
    }

}
