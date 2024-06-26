package testCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.Header;
import pages.Footer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageTest {
    static WebDriver driver;

    static CartPage cartPage;
    static Header header;
    static Footer footer;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/cart.html");
        cartPage = new CartPage(driver);
        header = new Header(driver);
        footer = new Footer(driver);
    }

    @Test
    public void testCartPageUrl() {
        // Verify the page URL
        String currentUrl = cartPage.getCurrentUrl();
        assertEquals(currentUrl, "https://www.demoblaze.com/cart.html","cart page url not current");
    }

//    @Test
//    public void testHeader() {
//        WebElement headerNavBar = header.getHeader();
//        assertTrue(headerNavBar.isDisplayed(), "header navigation bar is not displayed");
//    }
//
//    @Test
//    public void testFooter() {
//        WebElement footerNavBar = footer.getFooter();
//        assertTrue(footerNavBar.isDisplayed(), "footer navigation bar is not displayed");
//    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }


}
