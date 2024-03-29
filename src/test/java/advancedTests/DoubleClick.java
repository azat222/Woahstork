package advancedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick extends BaseTest {
    @Test()
    public void advancedTechniques() {
        driver.get("https://learn.woahstork.com/category/cannabis-science/");
        Actions actions = new Actions(driver);
        WebElement disordersDropDown = driver.findElement(By.xpath("//*[@id='menu-item-2616']//a[text()='Disorders']"));
        WebElement anxiety = driver.findElement(By.xpath("//*[@id='menu-item-2616']//a[text()='Anxiety']"));
        actions.moveToElement(disordersDropDown).moveToElement(anxiety).click().build().perform();
        String title = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h1[@class='page-title']")))).getText();
        System.out.println("title: "+title);
        Assert.assertEquals(title, "Anxiety");
    }
}