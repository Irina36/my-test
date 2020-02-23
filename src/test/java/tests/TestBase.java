package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(System.getProperty("BROWSER", BrowserType.CHROME));

    @BeforeClass
    public void setUp() throws IOException {
        app.init();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
