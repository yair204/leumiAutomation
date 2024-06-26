package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement getTotalPrice() {
         return driver.findElement(By.id("totalp"));

    }
    public WebElement getPlaceOrderButton() {
        return driver.findElement(By.className("btn-success"));
    }

    public WebElement getTable(){
        return driver.findElement(By.className("table-responsive"));
    }

}
