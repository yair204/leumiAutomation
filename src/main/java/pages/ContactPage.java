package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitDuration;

import java.time.Duration;


    public class ContactPage extends BasePage{

        public ContactPage(WebDriver driver) {
            super(driver, WaitDuration.MEDIUM);

        }

        private By emailField = By.id("recipient-email");
        private By nameField = By.id("recipient-name");
        private By messageField = By.id("message-text");
        private By sendButton = By.xpath("//button[contains(text(), 'Send message')]");

        public void setEmail(String email) {
            WebElement emailElement = driver.findElement(emailField);
            wait.until(ExpectedConditions.visibilityOf(emailElement));
            emailElement.clear();
            emailElement.sendKeys(email);
        }

        public void setName(String name) {
            WebElement nameElement = driver.findElement(nameField);
            wait.until(ExpectedConditions.visibilityOf(nameElement));
            nameElement.clear();
            nameElement.sendKeys(name);
        }

        public void setMessage(String message) {
            WebElement messageElement = driver.findElement(messageField);
            wait.until(ExpectedConditions.visibilityOf(messageElement));
            messageElement.clear();
            messageElement.sendKeys(message);
        }

        public void sendMessage() {
            driver.findElement(sendButton).click();
        }

        public String handleAlert() {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        }
    }




