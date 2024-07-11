package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitDuration;

public class Footer extends BasePage{
    String footerId;
    public Footer(WebDriver driver) {
        super(driver, WaitDuration.MEDIUM);
        this.footerId = "fotcont";

    }
    public WebElement getFooter() {

        return driver.findElement(By.id(footerId));

    }


}
