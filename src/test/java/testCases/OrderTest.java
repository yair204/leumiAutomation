package testCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import utils.WebDriverSingleton;


public class OrderTest {
    static WebDriver driver;
    static Order order;
    static String BaseUrl;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSingleton.getDriver();
        BaseUrl = "https://www.demoblaze.com/";
        driver.get(BaseUrl);
        driver.manage().window().maximize();
        order = new Order(driver, BaseUrl);
    }

    @Test
    public void addItems() {
        List<String> itemsName = order.addItemToCart(".card-title a.hrefch");
        List<String> itemsInCart = order.getItemsFromCart("tbodyid","td","tr");
        int prices = order.getPrices();
        int totalPrice = order.getTotalPrice("totalp");
        assertEquals(prices, totalPrice, "the total price not equal to items price");
        assertTrue(itemsName.containsAll(itemsInCart), "List name not equals");
    }

    @Test
    public void testCartItems() {
        order.addItemForAlert(".card-title a.hrefch");
        String alertText = order.handleAlert();
        System.out.println("Alert text: " + alertText);
        assertTrue(alertText.contains("Product added"));
    }

//    @AfterAll
//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
