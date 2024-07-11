package testCases;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import  utils.WebDriverSingleton;
import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeaderTest {
    static WebDriver driver;
    static Header navbarPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        navbarPage = new Header(driver);
    }

    @Test
    public void testNavbarLinks() {
        navbarPage.clickHomeLink();
        assertTrue(navbarPage.getCurrentUrl().endsWith("index.html"), "Expected to navigate to index.html");
        driver.navigate().refresh();

        navbarPage.clickLinkByText("Contact");
        assertTrue(navbarPage.isModalDisplayed("exampleModal"), "Expected Contact modal to be displayed");
        driver.navigate().refresh();
//
//        // Verify About us link
        navbarPage.clickLinkByText("About us");
        assertTrue(navbarPage.isModalDisplayed("videoModal"), "Expected About Us modal to be displayed");
        driver.navigate().refresh();

        navbarPage.clickLinkByText("Cart");
        assertTrue(navbarPage.getCurrentUrl().endsWith("cart.html"), "Expected to navigate to cart.html");
        driver.navigate().refresh();

        navbarPage.clickLinkByText("Log in");
        assertTrue(navbarPage.isModalDisplayed("logInModal"), "Expected Log In modal to be displayed");
        driver.navigate().refresh();

        navbarPage.clickLinkByText("Sign up");
        assertTrue(navbarPage.isModalDisplayed("signInModal"), "Expected Sign Up modal to be displayed");
        driver.navigate().refresh();

    }

//    @AfterAll
//    public static void tearDown() {
//        // Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
