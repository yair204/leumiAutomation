package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePageUrl() {
        // Verify the page URL
        String currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, "https://www.demoblaze.com/");
    }

    @Test
    public void testHomeGageCarousel(){
        WebElement carousel = homePage.getCarousel();
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
        var categories = homePage.getCategories();

        // Verify that the categories are not empty
        assertTrue(categories.size() > 0);
    }

    @Test
    public void testGetItems() {
        // Get the list of item names
        List<String> items = homePage.getItems();

        // Verify that the items list is not empty
        assertTrue(items.size() > 0, "Expected items list to be non-empty.");

        // Optionally, verify specific item names if needed
        assertTrue(items.contains("Samsung galaxy s6"), "Expected to find Samsung galaxy s6.");
        assertTrue(items.contains("Nokia lumia 1520"), "Expected to find Nokia lumia 1520.");
        assertTrue(items.contains("Nexus 6"), "Expected to find Nokia lumia 1520.");
        assertTrue(items.contains("Samsung galaxy s7"), "Expected to find Nokia lumia 1520.");
        assertTrue(items.contains("Iphone 6 32gb"), "Expected to find Nokia lumia 1520.");
        assertTrue(items.contains("HTC One M9"), "Expected to find Nokia lumia 1520.");
        assertTrue(items.contains("Sony vaio i5"), "Expected to find Nokia lumia 1520.");
        assertTrue(items.contains("Sony vaio i7"), "Expected to find Nokia lumia 1520.");
        // Add more assertions for other items if needed
    }


    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
