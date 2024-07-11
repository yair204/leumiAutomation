package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitDuration;

import java.time.Duration;


public class Order extends BasePage {
    int numOfItems;
    List<Integer> prices;
    String BaseUrl;
    String suffix;

    public Order(WebDriver driver, String BaseUrl) {
        super(driver, WaitDuration.MEDIUM);
        this.numOfItems = 3;
        this.prices = new ArrayList<>();
        this.BaseUrl = BaseUrl;
        this.suffix = "cart.html";
    }

    public List<String> getItemsFromCart(String tableId ,String tdTag,String trTag) {
        List<String> itemNames = new ArrayList<>();
        driver.navigate().to(BaseUrl + suffix);
        if (driver.getCurrentUrl().endsWith(suffix)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tdTag)));
            WebElement tbody = driver.findElement(By.id(tableId));
            List<WebElement> rows = tbody.findElements(By.tagName(trTag));

            for (WebElement row : rows) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tdTag)));
                WebElement itemNameCell = row.findElements(By.tagName(tdTag)).get(1);
                WebElement priceCell = row.findElements(By.tagName(tdTag)).get(2);
                String itemName = itemNameCell.getText();
                itemNames.add(itemName);
                int price = Integer.parseInt(priceCell.getText());
                this.prices.add(price);

            }
        }
        return itemNames;
    }

    public void getPlaceOrderButton(String button) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'"+button+"')]"))).click();
    }

    public List<String> addItemToCart(String cardAllocator) {
        List<String> itemNames = new ArrayList<>();
        for (int i = 0; i < this.numOfItems; i++) {
            driver.navigate().to(BaseUrl);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cardAllocator)));
            List<WebElement> items = driver.findElements(By.cssSelector(cardAllocator));

            if (!items.isEmpty() && i < items.size()) {
                wait.until(ExpectedConditions.elementToBeClickable(items.get(i)));
                WebElement item = items.get(i);
                itemNames.add(item.getText());
                item.click();
                getPlaceOrderButton("Add to cart");
                acceptAlert(10);
            } else {
                System.out.println("No items found or index out of bounds");
                break;
            }
        }
        return itemNames;
    }

    public void addItemForAlert(String cssSelector) {
        driver.navigate().to(BaseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        List<WebElement> items = driver.findElements(By.cssSelector(cssSelector));
        wait.until(ExpectedConditions.elementToBeClickable(items.get(0)));
        WebElement item = items.get(0);
        item.click();
        getPlaceOrderButton("Add to cart");
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
        } catch (Exception e) {
            System.out.println("Alert not found within the specified time");
        }
    }

    public int getTotalPrice(String totalpId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(totalpId)));
        WebElement totalElement = driver.findElement(By.id(totalpId));
        String totalText = totalElement.getText();
        return Integer.parseInt(totalText);
    }

    public int getPrices() {
        return prices.stream().mapToInt(Integer::intValue).sum();
    }
}
