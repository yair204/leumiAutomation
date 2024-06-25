package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {
    WebDriver driver;
    public Footer(WebDriver driver) {
        this.driver = driver;

    }
    public WebElement getFooter() {

        return driver.findElement(By.id("fotcont"));

    }


}
