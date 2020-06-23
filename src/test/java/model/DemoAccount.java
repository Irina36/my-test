package model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "demo_account")
public class DemoAccount {

    @Expose
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "currency_id")
    @Type(type = "int")
    private Integer currency;

    @Column(name = "amount")
    @Type(type = "big_decimal")
    private BigDecimal amount;

    @Column(name = "type_id")
    @Type(type = "int")
    private Integer typeAccount;


    public Integer getCurrency() {
        return currency;
    }

    public DemoAccount setCurrency(Integer currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public DemoAccount setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public int getId() {
        return id;
    }

    public Integer getTypeAccount() {
        return this.typeAccount;
    }

    public DemoAccount setTypeAccount(Integer typeAccount) {
        this.typeAccount = typeAccount;
        return this;
    }

    public DemoAccount setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "DemoAccount{" +
                "id=" + id +
                ", currency=" + currency +
                ", amount=" + amount +
                ", typeAccount=" + typeAccount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DemoAccount)) return false;
        DemoAccount that = (DemoAccount) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
