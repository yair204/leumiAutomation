package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.ArrayList;


public class HomePage {
    WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getCategories() {
        WebElement categoriesList = driver.findElement(By.className("list-group"));
        List<WebElement> categories = categoriesList.findElements(By.tagName("a"));
        for (WebElement category : categories) {
            System.out.println(category.getText());
        }
        return categories;
    }


    public List<String> getItems() {
        List<String> itemNames = new ArrayList<>();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a.hrefch")));

        List<WebElement> items = driver.findElements(By.cssSelector(".card-title a.hrefch"));

        for (WebElement item : items) {
            String itemName = item.getText();
            itemNames.add(itemName);
        }

        return itemNames;
    }


    public WebElement getCarousel(){
        return driver.findElement(By.id("carouselExampleIndicators"));
    }



}
