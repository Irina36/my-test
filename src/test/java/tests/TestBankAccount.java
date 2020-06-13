package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BankAccount;
import model.DemoAccount;
import model.Objects;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestBankAccount extends TestBase {

    ObjectMapper mapper = new ObjectMapper();

    @DataProvider(name = "data")
    public Iterator<Object[]> testData(ITestContext nameFile) throws IOException {
        File file = app.getFile(nameFile);
        List<BankAccount> myObjects = mapper.readValue(file, new TypeReference<List<BankAccount>>() {});
        Iterator<Object[]> iterator = myObjects.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        return iterator;
    }

    @Test (dataProvider = "data")
    public void createBankAccount(BankAccount bank) throws InterruptedException {
        app.goTo().bankDetail();
        String customer = app.properties.getProperty("WEB_LOGIN");
        Objects<BankAccount> before = app.db().bankAccount(customer);
        app.accountBank().createBank(bank.getCurrency());
        app.accountBank().selectBank(bank.getTypeBank());
        app.accountBank().fillBankAccount(bank);
        app.accountBank().submit();
        Objects<BankAccount> after = app.db().bankAccount(customer);
        Assert.assertEquals(after.size(),before.size() + 1);
        Assert.assertEquals(after, before.withAdded(bank.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())));

    }
}
