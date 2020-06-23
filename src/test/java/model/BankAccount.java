package model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customer_bank")

public class BankAccount {

    @Expose
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "is_alfa")
    @Type(type = "boolean")
    private boolean typeBank;

    @Column(name = "currency_id")
    @Type(type = "int")
    private int currency;

    @Column(name = "bank_name")
    @Type(type = "string")
    private String bankName;

    @Column(name = "bik")
    @Type(type = "string")
    private String bik;

    @Column(name = "inn")
    @Type(type = "string")
    private String inn;

    @Column(name = "kpp")
    @Type(type = "string")
    private String kpp;

    @Column(name = "account_corresp")
    @Type(type = "string")
    private String accountCorresp;

    @Column(name = "bank_account")
    @Type(type = "string")
    private String numberAccount;

    @Column(name = "bank_swift")
    @Type(type = "string")
    private String swift;

    @Column(name = "bank_corresp")
    @Type(type = "string")
    private String corrBank;

    @Column(name = "swift_corresp")
    @Type(type = "string")
    private String corrSwift;


    public int getId() {
        return id;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public boolean getTypeBank() {
        return typeBank;
    }

    public int getCurrency() {
        return currency;
    }

    public String getBankName() {
        return bankName;
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

    public String getAccountCorresp() {
        return accountCorresp;
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

    public BankAccount setId(int id) {
        this.id = id;
        return this;
    }

    public BankAccount setCurrency(int currency) {
        this.currency = currency;
        return this;
    }

    public BankAccount setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public BankAccount setBik(String bik) {
        this.bik = bik;
        return this;
    }

    public BankAccount setInn(String inn) {
        this.inn = inn;
        return this;
    }

    public BankAccount setKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    public BankAccount setAccountCorresp(String accountCorresp) {
        this.accountCorresp = accountCorresp;
        return this;
    }

    public BankAccount setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
        return this;
    }

    public BankAccount setTypeBank(boolean typeBank) {
        this.typeBank = typeBank;
        return this;
    }

    public BankAccount setSwift(String swift) {
        this.swift = swift;
        return this;
    }

    public BankAccount setCorrBank(String corrBank) {
        this.corrBank = corrBank;
        return this;
    }

    public BankAccount setCorrSwift(String corrSwift) {
        this.corrSwift = corrSwift;
        return this;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
