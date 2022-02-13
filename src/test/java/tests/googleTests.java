package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {

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
    @DisplayName("Поиск числа результатов")
    public void test1() {
        SearchPage.search("selenuim");
        assertEquals(13, SearchPage.results.size());

    }
    @Test
    @DisplayName("Проверка деталей ресурса")
    public void test2() {
        SearchPage.search("selenuim");
        assertAll(
        () -> assertEquals("3.141.59 (14 ноября 2018 года)", detailsPage.getLastVersion()),
        () -> assertEquals("Apache License 2.0", detailsPage.getLicense()),
        () -> assertEquals("Selenium", detailsPage.getName())
        );
    }
@AfterAll
    public static void teardown() {
        driver.quit();
}
}
