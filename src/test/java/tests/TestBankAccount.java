package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BankAccountData;
import model.DemoAccountData;
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
        List<BankAccountData> myObjects = mapper.readValue(file, new TypeReference<List<BankAccountData>>() {});
        Iterator<Object[]> iterator = myObjects.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        return iterator;
    }

    @Test (dataProvider = "data")
    public void createBankAccount(BankAccountData bank) throws InterruptedException {
        app.goTo().bankDetail();
        app.accountBank().createBank(bank.getCurrency());
        app.accountBank().selectBank(bank.getTypeBank());
        app.accountBank().fillBankAccount(bank);
        app.accountBank().submit();
    }
}
