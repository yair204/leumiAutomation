package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitDuration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this(driver, WaitDuration.MEDIUM); // Default to MEDIUM duration
    }

    public BasePage(WebDriver driver, WaitDuration duration) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, duration.getDuration());
    }
}
