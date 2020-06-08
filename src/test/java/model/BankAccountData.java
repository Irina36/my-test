package model;

public class BankAccountData {

    private String typeBank;
    private String currency;
    private String nameBank;
    private String bik;
    private String inn;
    private String kpp;
    private String corrAccountAlfabank;
    private String numberAccount;
    private String swift;
    private String corrBank;
    private String corrSwift;
    private String corrAccountOtherbank;

    public String getNumberAccount() {
        return numberAccount;
    }

    public String getTypeBank() {
        return typeBank;
    }

    public String getCurrency() {
        return currency;
    }

    public String getNameBank() {
        return nameBank;
    }

    public String getBik() {
        return bik;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getCorrAccountAlfabank() {
        return corrAccountAlfabank;
    }

    public String getSwift() {
        return swift;
    }

    public String getCorrBank() {
        return corrBank;
    }

    public String getCorrSwift() {
        return corrSwift;
    }

    public String getCorrAccountOtherbank() {
        return corrAccountOtherbank;
    }

    public BankAccountData setNameBank(String nameBank) {
        this.nameBank = nameBank;
        return this;
    }

    public BankAccountData setBik(String bik) {
        this.bik = bik;
        return this;
    }

    public BankAccountData setInn(String inn) {
        this.inn = inn;
        return this;
    }

    public BankAccountData setKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    public BankAccountData setCorrAccountAlfabank(String corrAccountAlfabank) {
        this.corrAccountAlfabank = corrAccountAlfabank;
        return this;
    }

    public BankAccountData setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
        return this;
    }

    @Override
    public String toString() {
        return "BankAccountData{" +
                "typeBank='" + typeBank + '\'' +
                ", currency='" + currency + '\'' +
                ", nameBank='" + nameBank + '\'' +
                ", bik='" + bik + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", corrAccountAlfabank='" + corrAccountAlfabank + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                ", swift='" + swift + '\'' +
                ", corrBank='" + corrBank + '\'' +
                ", corrSwift='" + corrSwift + '\'' +
                ", corrAccountOtherbank='" + corrAccountOtherbank + '\'' +
                '}';
    }
}
