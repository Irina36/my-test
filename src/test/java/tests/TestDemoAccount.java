package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.DemoAccountData;
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

    @DataProvider(name = "data")
    public Iterator<Object[]> testdata(ITestContext nameFile) throws IOException {
        File file = app.getFile(nameFile);
        List<DemoAccountData> myObjects = mapper.readValue(file, new TypeReference<List<DemoAccountData>>() {});
        Iterator<Object[]> iterator = myObjects.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        return iterator;
    }

    @Test(dataProvider = "data")
    public void createDemoAccount(DemoAccountData demo) throws InterruptedException {
        app.goTo().gotoDemoPage();
        app.accountDemo().createDemoAccount();
        app.accountDemo().fillDemoAccount(demo);
        app.accountDemo().submitDemoAccount();
        Assert.assertTrue(app.accountDemo().isTextPresent("Ваш демо-счет успешно создан"));
    }

    @Test(dataProvider = "data")
    public void notCreateDemoAccount(DemoAccountData demo) throws InterruptedException {
        app.goTo().gotoDemoPage();
        app.accountDemo().createDemoAccount();
        app.accountDemo().fillDemoAccount(demo);
        app.accountDemo().submitDemoAccount();
        Assert.assertFalse(app.accountDemo().isTextPresent("Ваш демо-счет успешно создан"));
    }
    @Test
    public void zeroBalance() throws InterruptedException {
        app.goTo().gotoDemoPage();
        app.accountDemo().zeroBalance(1,1);
        Assert.assertTrue(app.accountDemo().isTextPresent("Баланс обнулен"));
    }

    @Test
    public void delete() throws InterruptedException {
        app.goTo().gotoDemoPage();
        app.accountDemo().deleteAccount(1,1);
        Assert.assertTrue(app.accountDemo().isTextPresent("Счет удален"));
    }

    @Test
    public void deposit() throws InterruptedException {
        app.goTo().gotoDemoPage();
        app.accountDemo().deposit(1,1);
        app.accountDemo().amount("10000");
        app.accountDemo().submitDepositAccount();
        Assert.assertTrue(app.accountDemo().isTextPresent("Демо-счет успешно пополнен"));
    }

    @Test
    public void changePassword() throws InterruptedException {
        app.goTo().gotoDemoPage();
        app.accountDemo().changePass(1,1);
        app.accountDemo().fillChangePass();
        app.accountDemo().submitChangePass();
        Assert.assertTrue(app.accountDemo().isTextPresent("Пароль успешно изменен"));
    }
}