package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitDuration;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class CategoriesComponent extends BasePage {

    public CategoriesComponent(WebDriver driver) {
        super(driver, WaitDuration.MEDIUM);
    }

    private WebElement getCategoryElement(String category) {
        return driver.findElement(By.xpath(".//a[contains(text(),'" + category + "')]"));
    }

    public void getCategoryItems(String category) {
        WebElement categoryElement = getCategoryElement(category);
        wait.until(ExpectedConditions.elementToBeClickable(categoryElement)).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
