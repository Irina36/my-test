package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
}
