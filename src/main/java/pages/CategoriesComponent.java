package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class CategoriesComponent {
    WebDriver driver;
    WebDriverWait wait;

    public CategoriesComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement getCategoryElement(String category) {
        return driver.findElement(By.xpath(".//a[contains(text(),'" + category + "')]"));
    }

    public List<String> getLaptopsCategory() {
        return getCategoryItems("Laptops");
    }

    public List<String> getPhonesCategory() {
        return getCategoryItems("Phones");
    }

    public List<String> getMonitorsCategory() {
        return getCategoryItems("Monitors");
    }

    private List<String> getCategoryItems(String category) {
        List<String> itemNames = new ArrayList<>();
        try {
            WebElement categoryElement = getCategoryElement(category);
            wait.until(ExpectedConditions.elementToBeClickable(categoryElement)).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-title a.hrefch")));


            List<WebElement> items = driver.findElements(By.cssSelector(".card-title a.hrefch"));
            itemNames.clear(); // Clear the list before adding new items
            for (WebElement item : items) {
                String itemName = item.getText();
                itemNames.add(itemName);
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException encountered, retrying...");
            return getCategoryItems(category); // Retry fetching the items
        }
        return itemNames;
    }
}
