package testCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.OrderFormPage;
import utils.WebDriverSingleton;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderFormPageTest {

    static WebDriver driver;
    static OrderFormPage orderForm;
    static String orderModal;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.get("https://www.demoblaze.com/cart.html");
        driver.manage().window().maximize();
        orderModal = "orderModal";
        orderForm = new OrderFormPage(driver,orderModal);


    }

    @Test
    public void testOrderDetails(){
        String name = "yair dagan";
        String creditCard = "1234567812345678";
        String country = "israel";
        String city = "tlv";
        String month = "5";
        String year = "2025";

        orderForm.getPlaceOrderButton("btn-success");
        orderForm.fillOrderForm(name, country, city, creditCard, month, year);
        orderForm.pressButton("Purchase");
        String details = orderForm.getOrderConfirmationDetails(".lead.text-muted");
        assertTrue(details.contains(name) ,"Name error");
        assertTrue(details.contains(creditCard),"Card error");
        WebElement orderModel = orderForm.getOrderModel();
        assertTrue(orderModel.isDisplayed(),"Order form not displayed");

    }

//    @AfterAll
//    public static void tearDown() {
//        // Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
