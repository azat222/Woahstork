package advancedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverExample extends BaseTest {

    @Test
    public void hover() {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector("#sub-menu"));
        Action mouseOverHome = builder.moveToElement(element).build();
        mouseOverHome.perform();
        driver.findElement(By.cssSelector("#link2")).click();

    }

}
