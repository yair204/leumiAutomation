package testCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import pages.ContactPage;
import utils.WebDriverSingleton;


public class ContactPageTest {

        static WebDriver driver;
        static ContactPage contactPage;

        @BeforeAll
        public static void setUp() {
            driver = WebDriverSingleton.getDriver();
            driver.manage().window().maximize();
            driver.get("https://www.demoblaze.com/#");

            // Open the contact modal
            driver.findElement(By.xpath("//a[contains(text(), 'Contact')]")).click();
            contactPage = new ContactPage(driver);
        }

        @Test
        public void testSendMessage() {
            contactPage.setEmail("test@example.com");
            contactPage.setName("John Doe");
            contactPage.setMessage("This is a test message.");
            contactPage.sendMessage();

            // Handle the alert and verify its text
            String alertText = contactPage.handleAlert();
            System.out.println("Alert text: " + alertText);
            assertTrue(alertText.contains("Thanks for the message!!"), "Expected alert text not found.");
        }

//        @AfterAll
//        public static void tearDown() {
//            // Close the browser
//            if (driver != null) {
//                driver.quit();
//            }
//        }
    }


