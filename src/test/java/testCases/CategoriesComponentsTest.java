package testCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CategoriesComponent;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoriesComponentsTest {
    static WebDriver driver;
    static CategoriesComponent categoriesComponent;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/#");
        driver.manage().window().maximize();
        categoriesComponent = new CategoriesComponent(driver);
    }

    @Test
    public void getMonitorsCategory() {
        List<String> expectedItems = Arrays.asList("Apple monitor 24", "ASUS Full HD");
        List<String> actualItems = categoriesComponent.getMonitorsCategory();
        System.out.println("Monitors");
        System.out.println(actualItems);
        assertTrue(actualItems.containsAll(expectedItems), "Expected to find all items in Monitors category.");
    }
    @Test
    public void getPhonesCategory() {
        List<String> expectedItems = Arrays.asList("Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7", "Iphone 6 32gb", "Sony xperia z5", "HTC One M9");
        List<String> actualItems = categoriesComponent.getPhonesCategory();
        System.out.println("Phones");
        System.out.println(actualItems);
        assertTrue(actualItems.containsAll(expectedItems), "Expected to find all items in Phones category.");
    }

    @Test
    public void getLaptopsCategory() {
        List<String> expectedItems = Arrays.asList("Sony vaio i5", "Sony vaio i7", "MacBook air", "Dell i7 8gb", "2017 Dell 15.6 Inch", "MacBook Pro");
        List<String> actualItems = categoriesComponent.getLaptopsCategory();
        System.out.println("Laptops");
        System.out.println(actualItems);
        assertTrue(actualItems.containsAll(expectedItems), "Expected to find all items in Laptops category.");
    }


    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
