package appmanager;

import model.Objects;
import model.DemoAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class DemoAccountHelper extends HelperBase {

    By create = By.xpath("//*[@id=\"content\"]/div[1]/a");
    By typeAccount = By.xpath("//*[@id=\"select2-create_demo_account_account_type-container\"]");
    By hedging = By.xpath("//ul[@id=\"select2-create_demo_account_account_type-results\"]/li[1]");
    By netting = By.xpath("//ul[@id=\"select2-create_demo_account_account_type-results\"]/li[2]");
    By currency = By.xpath("//*[@id=\"content\"]/form/div[2]/span/span[1]/span");
    By rub = By.xpath("//ul[@id=\"select2-choice-currency-results\"]//li[text()='RUB']");
    By usd = By.xpath("//ul[@id=\"select2-choice-currency-results\"]//li[text()='USD']");
    By eur = By.xpath("//ul[@id=\"select2-choice-currency-results\"]//li[text()='EUR']");
    By balance = By.xpath("//*[@id=\"create_demo_account_balance\"]");
    By submitCreate =  By.xpath("//*[@id=\"create_demo_account_submit\"]");
    By table = By.xpath("//*[@id=\"content\"]/table/tbody");
    By zero = By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[6]/a[1]");
    By delete = By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[6]/a[2]");
    By deposit = By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[6]/a[3]");
    By depositAmount = By.xpath("//*[@id=\"demo_deposit_amount\"]");
    By submitDeposit = By.xpath("//*[@id=\"demo_deposit_submit\"]");
    By changePass = By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[6]/a[4]");
    By passVois = By.xpath("//form[@class='form form-password']/div[1]/input");
    By passTrade = By.xpath("//form[@class='form form-password']/div[2]/input");
    By passInvestor = By.xpath("//form[@class='form form-password']/div[3]/input");
    By submitChangePass = By.xpath("//form[@class='form form-password']/button");


    public DemoAccountHelper(WebDriver driver) {
        super(driver);
    }

    public void createDemoAccount() {
        click(create);
    }

    public void fillDemoAccount(DemoAccount demoAccountData) throws InterruptedException {

        if (demoAccountData.getTypeAccount() == null & demoAccountData.getCurrency() == null & demoAccountData.getAmount() == null) {
            return;

        } else {

            if (demoAccountData.getTypeAccount() == null) {

            } else {
                click(typeAccount);

                switch (demoAccountData.getTypeAccount()) {
                    case 2:
                        click(hedging);
                        break;
                    case 3:
                        click(netting);
                        break;
                }
            }

            if (demoAccountData.getCurrency() == null) {

            } else {
                click(currency);

                switch (demoAccountData.getCurrency()) {
                    case 3:
                        click(rub);
                        break;
                    case 1:
                        click(usd);
                        break;
                    case 2:
                        click(eur);
                        break;
                    default:
                        break;
                }
            }
            if (demoAccountData.getAmount() != null) {
                typeText(balance, String.valueOf(demoAccountData.getAmount()));
            }
        }
    }

    public void submitDemoAccount() {
        click(submitCreate);
    }

    public void zeroBalance(int rowNumber, int columnNumber) throws InterruptedException {
        selectValue(table, rowNumber, columnNumber, zero);
        Thread.sleep(2000);
    }

    public void deleteAccount(int rowNumber, int columnNumber) throws InterruptedException {
        selectValue(table, rowNumber, columnNumber, delete);
        Thread.sleep(2000);
    }

    public void deposit(int rowNumber, int columnNumber) throws InterruptedException {
        selectValue(table, rowNumber, columnNumber, deposit);
    }

    public void amount(String amount) {
        typeText(depositAmount, amount);
    }
    public void submitDepositAccount() throws InterruptedException {
        click(submitDeposit);
        Thread.sleep(2000);
    }

    public void changePass(int rowNumber, int columnNumber) throws InterruptedException {
        selectValue(table, rowNumber, columnNumber, changePass);
        Thread.sleep(2000);
    }

    public void fillChangePass () throws InterruptedException {
        typeText(passVois, "QWEasd123");
        typeText(passTrade, "QWEasd123");
        typeText(passInvestor, "QWEasd123");
    }

    public void submitChangePass() throws InterruptedException {
        click(submitChangePass);
        Thread.sleep(3000);
    }

    public Objects all() {
        Objects demoObjects = new Objects();
        WebElement t = driver.findElement(table);
        List<WebElement> rows = t.findElements(By.xpath("./tr[@data-key]"));
        for (WebElement row : rows) {
            int id = Integer.parseInt(row.getAttribute("data-key"));
            demoObjects.add(new DemoAccount().setId(id));
        }
        return demoObjects;
    }


}
