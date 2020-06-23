package appmanager;

import model.BankAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankAccountHelper extends HelperBase {
    public BankAccountHelper(WebDriver driver) {
        super(driver);
    }
    By linkRub = By.xpath("//*[@id=\"content\"]/div[2]/a[1]");
    By linkUsd = By.xpath("//*[@id=\"content\"]/div[2]/a[2]");
    By linkEur = By.xpath("//*[@id=\"content\"]/div[2]/a[3]");
    By alfaBank = By.xpath("//*[@id=\"content\"]/form/div[1]/div/div/label[1]/div");
    By otherBank = By.xpath("//*[@id=\"content\"]/form/div[1]/div/div/label[2]/div");
    By numberAccount = By.xpath("//*[@id=\"bank_account\"]");
    By submit =By.xpath("//*[@id=\"bank_submit\"]");
    By name =By.xpath("//*[@id=\"bank_name\"]");
    By bik =By.xpath("//*[@id=\"bank_bik\"]");
    By inn =By.xpath("//*[@id=\"bank_tax_number\"]");
    By kpp =By.xpath("//*[@id=\"bank_kpp\"]");
    By accountCorresp = By.xpath("//div[@class='form-column']/div/div[4]/input");
    By swift = By.xpath("//*[@id=\"bank_swift\"]");
    By correspondentBank = By.xpath("//*[@id=\"bank_correspondent\"]");
    By getCorrespondentSwift = By.xpath("//*[@id=\"bank_correspondent_swift\"]");

    public void createBank(int currency) {
        switch (currency) {
            case (3):
                click(linkRub);
                break;
            case (1):
                click(linkUsd);
                break;
            case (2):
                click(linkEur);
                break;
        }
    }

    public void selectBank(boolean typeBank) {

        if (typeBank) {
            click(alfaBank);
        } else
            click(otherBank);
        }

    public void fillBankAccount(BankAccount bankAccountData) {

        if (bankAccountData.getTypeBank() == true) {
            typeText(numberAccount,bankAccountData.getNumberAccount());
        }
        if (bankAccountData.getTypeBank() == false && bankAccountData.getCurrency() == 3){
            typeText(name, bankAccountData.getBankName());
            typeText(bik, bankAccountData.getBik());
            typeText(inn, bankAccountData.getInn());
            typeText(kpp, bankAccountData.getKpp());
            typeText(accountCorresp,bankAccountData.getAccountCorresp());
            typeText(numberAccount,bankAccountData.getNumberAccount());
        }
        else if (bankAccountData.getTypeBank() == false){
            typeText(name, bankAccountData.getBankName());
            typeText(swift, bankAccountData.getSwift());
            typeText(correspondentBank, bankAccountData.getCorrBank());
            typeText(getCorrespondentSwift, bankAccountData.getCorrSwift());
            typeText(accountCorresp, bankAccountData.getAccountCorresp());
            typeText(numberAccount,bankAccountData.getNumberAccount());
        }
    }

    public void submit() {
        click(submit);
    }
}
