package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.DemoAccountData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class TestDemoAccount extends TestBase {

    @DataProvider
    public Iterator<Object[]> testData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/demoAccountValidData.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json+=line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<DemoAccountData> accounts = gson.fromJson(json, new TypeToken<List<DemoAccountData>>() {}.getType());
            return accounts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "testData")
    public void createDemoAccount(DemoAccountData demo) throws InterruptedException {

        app.goTo().gotoDemoPage();
        app.accountDemo().createDemoAccount();
        app.accountDemo().fillDemoAccount(demo);
        app.accountDemo().submitDemoAccount();
        app.goTo().gotoDemoPage();

    }

}