package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {

    private static WebDriver driver;
    private static SearchPage SearchPage;

    @BeforeAll
    public static void init() {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        SearchPage = new SearchPage(driver);
    }
    @Test
    public void test1() {

        driver.get ("http://google.com");
        SearchPage.search("selenuim");
        assertEquals(13, SearchPage.results.size());

    }
@AfterAll
    public static void teardown() {
        driver.quit();
}
}
