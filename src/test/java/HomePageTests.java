import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests  extends  BaseTest {

    @Test
    public void SignUpSuccessTest () {

        openHomePage();
        clickGetVerifiedIcon();

        WebElement welcomeBack = getWelcomeBackElement();
        Assert.assertTrue(welcomeBack.isDisplayed());

    }

    private WebElement getWelcomeBackElement() {
        return findElement("[content='Welcome Back']");
    }

    private void clickGetVerifiedIcon() {
        findElement("[href='/profile']").click();
    }

    private void openHomePage() {
        driver.get("https://test.woahstork.com/");
    }

    private WebElement findElement(String cssLocator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
    }

}
