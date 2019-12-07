package advancedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scroll extends BaseTest {

    @Test
    public void scrollByCoordinate() {
        driver.get("https://test.woahstork.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;;
        js.executeScript("window.scrollTo(0, 600)");


    }

    @Test
    public void scrollToBottomOfPage() {
        driver.get("https://test.woahstork.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


    }

    @Test
    public void scrollToElement() {
        driver.get("https://test.woahstork.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;;

        WebElement Element = driver.findElement(By.xpath("//a[text()=\"Cannabis Science\"]"));

        js.executeScript("arguments[0].scrollIntoView();", Element);


    }
}
