package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    public final Properties properties;
    public NavigationHelper navigationHelper;
    public DemoAccountHelper demoAccountHelper;
    public SessionHelper sessionHelper;
    private BankAccountHelper bankDetailHelper;
    private String browser;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }   
    
    public void properties() throws IOException {
        String target = System.getProperty("target", "app");
        properties.load(new FileReader(new File(String.format("src/test/java/config/%s.properties", target))));
    }

    public void init() throws IOException {
        properties();
        
        dbHelper =new DbHelper();

        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(properties.getProperty("WEB_BASE_URL"));

        demoAccountHelper = new DemoAccountHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        bankDetailHelper = new BankAccountHelper(driver);
        sessionHelper.login(properties.getProperty("WEB_LOGIN"), properties.getProperty("WEB_PASSWORD"));
    }

    public File getFile(ITestContext nameFile) throws IOException {
        properties();
        String path_to_data_files = properties.getProperty("PATH_TO_DATA_FILES");
        String name = nameFile.getCurrentXmlTest().getParameter("nameFile");
        return new File(path_to_data_files + name);
    }

    public void stop() {
        driver.quit();
    }

    public DemoAccountHelper accountDemo() {
        return demoAccountHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public BankAccountHelper accountBank() {
        return bankDetailHelper;
    }
    public SessionHelper session() {
        return sessionHelper;
    }
    public DbHelper db() { return dbHelper; }
}
