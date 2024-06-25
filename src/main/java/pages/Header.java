package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;

    }
    public WebElement getHeader() {

        return driver.findElement(By.id("navbarExample"));

    }


}
