package advancedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeysExample extends BaseTest {

    @Test
    public void keys() {
        driver.get("https://deens-master.now.sh/");

        // Initiate action class
        Actions builder = new Actions(driver);

        // Finds Search element
        WebElement element = driver.findElement(By.cssSelector("[name='search']"));

        //Perform series of actions
        Action seriesOfActions = builder
                .moveToElement(element)
                .click()
                .keyDown(element, Keys.SHIFT)
                .sendKeys(element, "hello")
                .keyUp(element, Keys.SHIFT)
                .doubleClick(element)
                .contextClick()
                .build();

        seriesOfActions.perform();


    }

}
