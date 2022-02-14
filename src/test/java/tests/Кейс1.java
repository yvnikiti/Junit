package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Кейс1 {

    private static WebDriver driver;
    private static SearchPage SearchPage;
    private static DetailsPage detailsPage;

    @BeforeAll
    public static void init() {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        SearchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
    }
    @BeforeEach
    public void setup() {
        driver.get("http://google.com");
    }
    @Test
    @DisplayName("Проверка операций с целыми числами")
    public void test1() {
        SearchPage.search("Калькулятор");
                  }

     @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
