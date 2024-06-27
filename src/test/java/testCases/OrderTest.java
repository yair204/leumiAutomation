package testCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import pages.Order;
import java.time.Duration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTest {
    static WebDriver driver;
    static Order order;


    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        order = new Order(driver);

    }

    @Test
    public void addItems(){
        List<String> itemsName = order.addItemToCart();
        List<String> itemsInCart = order.getItemsFromCart();
        assertTrue(itemsName.containsAll(itemsInCart), "List name not equals");
    }

    @Test
    public void testCartItems(){
        order.addItemForAlert();
        String alertText = order.handleAlert();
        System.out.println("Alert text: " + alertText);
        assertTrue(alertText.contains("Product added"));
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }



}
