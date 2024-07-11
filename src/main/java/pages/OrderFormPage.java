package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderFormPage  extends BasePage{

    String orderModal;

    public OrderFormPage(WebDriver driver ,String orderModal) {
        super(driver);
        this.orderModal = orderModal;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillOrderForm(String name, String country, String city, String creditCard, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orderModal)));

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement countryField = driver.findElement(By.id("country"));
        WebElement cityField = driver.findElement(By.id("city"));
        WebElement cardField = driver.findElement(By.id("card"));
        WebElement monthField = driver.findElement(By.id("month"));
        WebElement yearField = driver.findElement(By.id("year"));

        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(creditCard);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void pressButton(String button) {
        driver.findElement(By.xpath("//button[contains(text(),'"+ button +"')]")).click();
    }

    public void getPlaceOrderButton(String buttonClass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(buttonClass)));
        WebElement placeOrderButton =  driver.findElement(By.className(buttonClass));
        placeOrderButton.click();
    }

    public WebElement getOrderModel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orderModal)));
        return driver.findElement(By.id(orderModal));
    }

    public String getOrderConfirmationDetails(String confirmationDetailsAllocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(confirmationDetailsAllocator))).getText();

    }



}
