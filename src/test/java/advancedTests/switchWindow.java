package advancedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class switchWindow extends BaseTest {

    @Test
    public void multipleWindows() {

        driver.get("https://test.woahstork.com/register");
        WebElement link = findElement("[class*='styled__Bottom']");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        findElement("//button[contains(text(),'Got it!')]").click(); //trying to close this pop
        findElement("//a[contains(text(),'Already have an account')]").click();

    }

    protected WebElement findElement(String cssLocator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
    }
}
