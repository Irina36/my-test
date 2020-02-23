package model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demo_account")
public class DemoAccountData {

    @Expose
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "currency_id")
    private  String currency;

    @Column(name = "amount")
    @Type(type = "longtext")
    private  String balance;

    @Column(name = "type_id")
    private  String typeAccount;

    public String getCurrency() {
        return currency;
    }

    public DemoAccountData setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getBalance() {
        return balance;
    }

    public DemoAccountData setBalance(String balance) {
        this.balance = balance;
        return this;
    }

    public String getTypeAccount() {
        return this.typeAccount;
    }

    public DemoAccountData setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
        return this;
    }

    @Override
    public String toString() {
        return "DemoAccountData{" +
                "currency='" + currency + '\'' +
                ", balance='" + balance + '\'' +
                ", typeAccount='" + typeAccount + '\'' +
                '}';
    }
}
