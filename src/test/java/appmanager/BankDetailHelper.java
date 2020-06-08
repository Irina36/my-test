package appmanager;

import model.BankAccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankDetailHelper extends HelperBase {
    public BankDetailHelper(WebDriver driver) {
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
    By corrAccountAlfabank = By.xpath("//*[@id=\"bank_bill\"]");
    By swift = By.xpath("//*[@id=\"bank_swift\"]");
    By correspondentBank = By.xpath("//*[@id=\"bank_correspondent\"]");
    By getCorrespondentSwift = By.xpath("//*[@id=\"bank_correspondent_swift\"]");
    By corrAccountOtherbank = By.xpath("//*[@id=\"bank_correspondent_account\"]");

    public void createBank(String currency) {
        switch (currency) {
            case ("RUB"):
                click(linkRub);
                break;
            case ("USD"):
                click(linkUsd);
                break;
            case ("EUR"):
                click(linkEur);
                break;
        }
    }

    public void selectBank(String typeBank) {
        switch (typeBank) {
            case ("ALFABANK"):
                click(alfaBank);
                break;
            case ("OTHER_BANK"):
                click(otherBank);
                break;
            }
        }

    public void fillBankAccount(BankAccountData bankAccountData) {

        if (bankAccountData.getTypeBank().equals("ALFABANK")) {
            typeText(numberAccount,bankAccountData.getNumberAccount());
        }
        if (bankAccountData.getTypeBank().equals("OTHER_BANK") && bankAccountData.getCurrency().equals("RUB")){
            typeText(name, bankAccountData.getNameBank());
            typeText(bik, bankAccountData.getBik());
            typeText(inn, bankAccountData.getInn());
            typeText(kpp, bankAccountData.getKpp());
            typeText(corrAccountAlfabank,bankAccountData.getCorrAccountOtherbank());
            typeText(numberAccount,bankAccountData.getNumberAccount());

        } else if (bankAccountData.getTypeBank().equals("OTHER_BANK")){
            typeText(name, bankAccountData.getNameBank());
            typeText(swift, bankAccountData.getSwift());
            typeText(correspondentBank, bankAccountData.getCorrBank());
            typeText(getCorrespondentSwift, bankAccountData.getCorrSwift());
            typeText(corrAccountOtherbank, bankAccountData.getCorrAccountOtherbank());
            typeText(numberAccount,bankAccountData.getNumberAccount());
        }
    }

    public void submit() {
        click(submit);
    }
}
