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

public class CategoriesComponent extends BasePage {

    public CategoriesComponent(WebDriver driver) {
        super(driver);
    }

    private WebElement getCategoryElement(String category) {
        return driver.findElement(By.xpath(".//a[contains(text(),'" + category + "')]"));
    }

    public List<String> getLaptopsCategory(String laptops,String cssSelector) {
        return getCategoryItems(laptops,cssSelector);
    }

    public List<String> getPhonesCategory(String phones,String cssSelector) {
        return getCategoryItems(phones,cssSelector);
    }

    public List<String> getMonitorsCategory(String monitors,String cssSelector) {
        return getCategoryItems(monitors,cssSelector);
    }

    private List<String> getCategoryItems(String category,String cssSelector) {
        List<String> itemNames = new ArrayList<>();
        try {
            WebElement categoryElement = getCategoryElement(category);
            wait.until(ExpectedConditions.elementToBeClickable(categoryElement)).click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelector)));


            List<WebElement> items = driver.findElements(By.cssSelector(cssSelector));
            itemNames.clear();
            for (WebElement item : items) {
                String itemName = item.getText();
                itemNames.add(itemName);
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException encountered, retrying...");
            return getCategoryItems(category,cssSelector); // Retry fetching the items
        }
        return itemNames;
    }
}
