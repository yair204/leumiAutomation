package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitDuration;

import java.util.List;
import java.time.Duration;


public class Header extends BasePage{

    String headerId ;
    String navbarLinks;
    public Header(WebDriver driver) {
        super(driver, WaitDuration.MEDIUM);
        this.headerId = "navbarExample";
        this.navbarLinks = "#navbarExample .nav-link";


    }
    public WebElement getHeader() {
        return driver.findElement(By.id(headerId));
    }


    public List<WebElement> getNavbarLinks() {
        return driver.findElements(By.cssSelector(navbarLinks));
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
