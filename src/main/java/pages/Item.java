package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Item {
    WebDriver driver;
    WebDriverWait wait;
    String cssSelectorAllocator;
    public Item(WebDriver driver){
        this.driver = WebDriverSingleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.cssSelectorAllocator = ".card-title a.hrefch";

    }
    public List<String> getItems() {
        List<String> itemNames = new ArrayList<>();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(cssSelectorAllocator)));

        List<WebElement> items = driver.findElements(By.cssSelector(cssSelectorAllocator));
        for (WebElement item : items) {
            String itemName = item.getText();
            itemNames.add(itemName);
        }

        return itemNames;
    }
}
