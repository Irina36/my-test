package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver=driver;
    }

    public void typeText(By locator, String text)  {
        click(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isTextPresent(String text) {
        try {
            return driver.findElement(By.tagName("body")).getText().contains(text);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void actionsMouse(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.click(webElement).perform();
    }

    public Table getTable(WebElement element) {
        return  new Table(element);
    }

    public void selectValue(By table, int rowNumber, int columnNumber, By locator) throws InterruptedException {
        Table t = getTable(driver.findElement(table));
        WebElement valueFromCell = t.getValueFromCell(rowNumber, columnNumber);
        actionsMouse(valueFromCell);
//        WebDriverWait myWaitVar = new WebDriverWait(driver, 7);
//        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement zero = valueFromCell.findElement(locator);
        zero.click();
    }
}
