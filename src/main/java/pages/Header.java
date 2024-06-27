package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;


public class Header {
    WebDriver driver;
    WebDriverWait wait;
    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    public WebElement getHeader() {
        return driver.findElement(By.id("navbarExample"));
    }


    public List<WebElement> getNavbarLinks() {
        return driver.findElements(By.cssSelector("#navbarExample .nav-link"));
    }

    public void clickLinkByText(String linkText) {
        for (WebElement link : getNavbarLinks()) {

            if (link.getText().equals(linkText)) {
                link.click();
                break;
            }
        }
    }

    public void clickHomeLink(){
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();
    }

    public boolean isModalDisplayed(String modalId) {
        WebElement modal = driver.findElement(By.id(modalId));
        wait.until(ExpectedConditions.visibilityOf(modal));

        return modal.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


}
