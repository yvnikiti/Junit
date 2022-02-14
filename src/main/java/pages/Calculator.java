package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Calculator {

    @FindBy(css = "div[jsname*='j93WEe']")
    private WebElement openClamp;

    @FindBy(css = "div[jsname*='N10B9']")
    private WebElement one;

    @FindBy(css = "div[jsname*='XSr6wc']")
    private WebElement plus;

    @FindBy(css = "div[jsname*='lVjWed']")
    private WebElement two;

    @FindBy(css = "div[jsname*='qCp9A']")
    private WebElement closeClamp;

    @FindBy(css = "div[jsname*='YovRWb']")
    private WebElement multiply;

    @FindBy(css = "div[jsname*='KN1kY']")
    private WebElement three;

    @FindBy(css = "div[jsname*='pPHzQc']")
    private WebElement minus;

    @FindBy(css = "div[jsname*='xAP7E']")
    private WebElement four;

    @FindBy(css = "div[jsname*='bkEvMb']")
    private WebElement zero;

    @FindBy(css = "div[jsname*='WxTTNd']")
    private WebElement divide;

    @FindBy(css = "div[jsname*='Ax5wH']")
    private WebElement five;

    @FindBy(css = "div[jsname*='Pt8tGc']")
    private WebElement result;

    @FindBy(css = "div[jsname*='zLiRgc']")
    private WebElement resultText;

    @FindBy(css = "div[jsname*='abcgof']")
    private WebElement six;

    @FindBy(css = "div[jsname*='aN1RFf']")
    private WebElement sin;

    @FindBy(css = "div[jsname*='VkJw6']")
    private WebElement beforeResult;

    public Calculator(WebDriver driver) {
        initElements(driver, this);
    }

    private void apply() {
        openClamp.click();
        one.click();
        plus.click();
        two.click();
        closeClamp.click();
        multiply.click();
        three.click();
        minus.click();
        four.click();
        zero.click();
        divide.click();
        five.click();
    }

    private ArrayList<String> getList() {
        result.click();
        ArrayList<String> result = new ArrayList<>();
        result.add(beforeResult.getText());
        result.add(resultText.getText());
        return result;
    }

    public ArrayList<String> getResult1() {
        apply();
        return getList();
    }

    public ArrayList<String> getResult2() {
        six.click();
        divide.click();
        zero.click();
        return getList();
    }

    public ArrayList<String> getResult3() {
        sin.click();
        return getList();
    }
}