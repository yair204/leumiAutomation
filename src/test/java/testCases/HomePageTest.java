package testCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.Header;
import pages.Footer;
import pages.Item;
import utils.WebDriverSingleton;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest {
    static WebDriver driver;
    static HomePage homePage;
    static Header header;
    static Footer footer;
    static Item item;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.get("https://www.demoblaze.com/");
        homePage = new HomePage(driver);
        header = new Header(driver);
        footer = new Footer(driver);
        item = new Item(driver);
    }

    @Test
    public void testHomePageUrl() {
        // Verify the page URL
        String currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, "https://www.demoblaze.com/");
    }

    @Test
    public void testHeader() {
        WebElement headerNavBar = header.getHeader();
        assertTrue(headerNavBar.isDisplayed(), "header navigation bar is not displayed");
    }

    @Test
    public void testFooter() {
        WebElement footerNavBar = footer.getFooter();
        assertTrue(footerNavBar.isDisplayed(), "footer navigation bar is not displayed");
    }

    @Test
    public void testHomeGageCarousel() {
        WebElement carousel = homePage.getCarousel("carouselExampleIndicators");
        assertTrue(carousel.isDisplayed(), "Carousel is not displayed");
    }

    @Test
    public void testHomePageTitle() {
        // Verify the page title
        String title = homePage.getPageTitle();
        assertEquals(title, "STORE");
    }

    @Test
    public void testGetCategories() {
        // Get the list of categories
        var categories = homePage.getCategories("list-group","a");

        // Verify that the categories are not empty
        assertFalse(categories.isEmpty());
    }

    @Test
    public void testGetItems() {
        // Get the list of item names
//        List<String> items = homePage.getItems();
        List<String> itemsNames = item.getItems();

        // Verify that the items list is not empty
        assertFalse(itemsNames.isEmpty(), "Expected items list to be non-empty.");

        // Optionally, verify specific item names if needed
        assertTrue(itemsNames.contains("Samsung galaxy s6"), "Expected to find Samsung galaxy s6.");
        assertTrue(itemsNames.contains("Nokia lumia 1520"), "Expected to find Nokia lumia 1520.");
        assertTrue(itemsNames.contains("Nexus 6"), "Expected to find Nokia lumia 1520.");
        assertTrue(itemsNames.contains("Samsung galaxy s7"), "Expected to find Nokia lumia 1520.");
        assertTrue(itemsNames.contains("Iphone 6 32gb"), "Expected to find Nokia lumia 1520.");
        assertTrue(itemsNames.contains("HTC One M9"), "Expected to find Nokia lumia 1520.");
        assertTrue(itemsNames.contains("Sony vaio i5"), "Expected to find Nokia lumia 1520.");
        assertTrue(itemsNames.contains("Sony vaio i7"), "Expected to find Nokia lumia 1520.");
    }

//    @AfterAll
//    public static void tearDown() {
//        // Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
