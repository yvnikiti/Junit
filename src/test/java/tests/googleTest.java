package Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Calculator;
import pages.Calculator;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTest {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static pages.Calculator calcPage;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        calcPage = new Calculator(driver);
    }

    @BeforeEach
    public void setup(){
        driver.get("https://google.com/");
    }

    @Test
    public void test1() {
        searchPage.search("Калькулятор");
        ArrayList<String> result = calcPage.getResult1();
        assertAll(
                () ->  assertEquals("(1 + 2) × 3 - 40 ÷ 5 =",result.get(0)),
                () ->  assertEquals("1",result.get(1))
        );


    }

    @Test
    public void test2() {
        searchPage.search("Калькулятор");
        ArrayList<String> result = calcPage.getResult2();
        assertAll(
                () ->  assertEquals("6 ÷ 0 =",result.get(0)),
                () ->  assertEquals("Infinity",result.get(1))
        );

    }

    @Test
    public void test3() {
        searchPage.search("калькулятор");
        ArrayList<String> result = calcPage.getResult3();
        assertAll(
                () ->  assertEquals("sin() =",result.get(0)),
                () ->  assertEquals("Error",result.get(1))
        );
    }
    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}