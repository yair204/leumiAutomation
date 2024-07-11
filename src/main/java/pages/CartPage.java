package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);

    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement getTotalPrice(String id) {
         return driver.findElement(By.id(id));

    }
    public WebElement getPlaceOrderButton(String className) {
        return driver.findElement(By.className(className));
    }

    public WebElement getTable(String table){
        return driver.findElement(By.className(table));
    }

}
