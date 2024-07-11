package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.ArrayList;


public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);

    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getCategories(String className ,String tagName) {
        WebElement categoriesList = driver.findElement(By.className(className));
        List<WebElement> categories = categoriesList.findElements(By.tagName(tagName));
        for (WebElement category : categories) {
            System.out.println(category.getText());
        }
        return categories;
    }





    public WebElement getCarousel(String carouselId ){
        return driver.findElement(By.id(carouselId));
    }



}
