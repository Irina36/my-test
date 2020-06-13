package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(System.getProperty("BROWSER", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws IOException {
        app.properties();
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
