package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;



import java.time.Duration;
import java.util.List;
import java.util.ArrayList;


public class Order {
    WebDriver driver;
    WebDriverWait wait;

    int numOfItems;

    public Order(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.numOfItems = 3;
    }

    public List<String> getItemsFromCart() {
        List<String> itemNames = new ArrayList<>();
        WebElement button = driver.findElement(By.xpath(".//a[contains(text(),'Cart')]"));
        button.click();
        if(driver.getCurrentUrl().endsWith("cart.html")) {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("td")));
            WebElement tbody = driver.findElement(By.id("tbodyid"));
            List<WebElement> rows = tbody.findElements(By.tagName("tr"));

            for (WebElement row : rows) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("td")));
                WebElement itemNameCell = row.findElements(By.tagName("td")).get(1);
                String itemName = itemNameCell.getText();
                itemNames.add(itemName);
            }
        }

        return itemNames;
    }

    public void getPlaceOrderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'Add to cart')]")));
        WebElement button = driver.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
        button.click();
    }

    public List<String> addItemToCart() {
        List<String> itemNames = new ArrayList<>();
        for (int i = 0; i < this.numOfItems; i++) {
            driver.navigate().to("https://www.demoblaze.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a.hrefch")));
            List<WebElement> items = driver.findElements(By.cssSelector(".card-title a.hrefch"));

            if (!items.isEmpty() && i < items.size()) {
                wait.until(ExpectedConditions.elementToBeClickable(items.get(i)));
                WebElement item = items.get(i);
                itemNames.add(item.getText());
                item.click();
                getPlaceOrderButton();
                acceptAlert(10);
            } else {
                System.out.println("No items found or index out of bounds");
                break;
            }
        }
        return itemNames;
    }

    public void addItemForAlert() {
        driver.navigate().to("https://www.demoblaze.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a.hrefch")));
        List<WebElement> items = driver.findElements(By.cssSelector(".card-title a.hrefch"));
        wait.until(ExpectedConditions.elementToBeClickable(items.get(0)));
        WebElement item = items.get(0);
        item.click();
        getPlaceOrderButton();

    }


    public String handleAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void acceptAlert(int timeoutInSeconds) {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("Alert not found within the specified time");
        }
    }
}
