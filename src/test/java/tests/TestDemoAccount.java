package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Objects;
import model.DemoAccount;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class TestDemoAccount extends TestBase {

    ObjectMapper mapper = new ObjectMapper();
    String customer = app.properties.getProperty("WEB_LOGIN");

    @DataProvider(name = "data")
    public Iterator<Object[]> testData(ITestContext nameFile) throws IOException {
        File file = app.getFile(nameFile);
        List<DemoAccount> myObjects = mapper.readValue(file, new TypeReference<List<DemoAccount>>() {});
        Iterator<Object[]> iterator = myObjects.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        return iterator;
    }

    @Test (dataProvider = "data")
    public void createDemoAccount(DemoAccount demo) throws InterruptedException {
        app.goTo().demoPage();
        Objects<DemoAccount> before = app.db().demoAccount(customer);
        app.accountDemo().createDemoAccount();
        app.accountDemo().fillDemoAccount(demo);
        app.accountDemo().submitDemoAccount();
        Assert.assertTrue(app.accountDemo().isTextPresent("Ваш демо-счет успешно создан"));
        Objects<DemoAccount> after = app.db().demoAccount(customer);
        Assert.assertEquals(after.size(),before.size() + 1);
        Assert.assertEquals(after, before.withAdded(demo.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())));
/*                .setTypeAccount(after.stream().map( (g) -> g.getTypeAccount()).iterator().next())
                .setAmount(after.stream().map((g) -> g.getAmount()).iterator().next())
                .setCurrency(after.stream().map((g) -> g.getCurrency()).iterator().next())));*/
    }
    @Test (dataProvider = "data")
    public void notCreateDemoAccount(DemoAccount demo) throws InterruptedException, IOException {

        app.goTo().demoPage();
        Objects<DemoAccount> before = app.db().demoAccount(customer);
        app.accountDemo().createDemoAccount();
        app.accountDemo().fillDemoAccount(demo);
        app.accountDemo().submitDemoAccount();
        Assert.assertFalse(app.accountDemo().isTextPresent("Ваш демо-счет успешно создан"));
        app.goTo().demoPage();
        Objects<DemoAccount> after = app.db().demoAccount(customer);
        Assert.assertEquals(after.size(),before.size());
        Assert.assertEquals(after,before);
    }
    @Test
    public void zeroBalance() throws InterruptedException {
        app.goTo().demoPage();
        Objects<DemoAccount> before = app.db().demoAccount(customer);
        app.accountDemo().zeroBalance(1,1);
        Assert.assertTrue(app.accountDemo().isTextPresent("Баланс обнулен"));
        Objects<DemoAccount> after = app.db().demoAccount(customer);

    }

    @Test
    public void delete() throws InterruptedException {
        app.goTo().demoPage();
        Objects before = app.db().demoAccount(customer);
        app.accountDemo().deleteAccount(1,1);
        Assert.assertTrue(app.accountDemo().isTextPresent("Счет удален"));
        Objects after = app.db().demoAccount(customer);
        Assert.assertEquals(after.size(),before.size() - 1);
    }

    @Test
    public void deposit() throws InterruptedException {
        app.goTo().demoPage();
        app.accountDemo().deposit(1,1);
        app.accountDemo().amount("10000");
        app.accountDemo().submitDepositAccount();
        Assert.assertTrue(app.accountDemo().isTextPresent("Демо-счет успешно пополнен"));
    }

    @Test
    public void changePassword() throws InterruptedException {
        app.goTo().demoPage();
        app.accountDemo().changePass(1,1);
        app.accountDemo().fillChangePass();
        app.accountDemo().submitChangePass();
        Assert.assertTrue(app.accountDemo().isTextPresent("Пароль успешно изменен"));
    }
}