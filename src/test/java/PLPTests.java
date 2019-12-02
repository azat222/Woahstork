import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PLPTests extends  BaseTest {

    @Test
    public void SignUpSuccessTest () {
        openPLPPage();
        clickCartButton();
        WebElement el = getCheckoutElement();

        Assert.assertEquals(el.getText(), "CHECKOUT");
    }

    private WebElement getCheckoutElement() {
        return findElement("[class*='ButtonWrapper'] a");
    }

    private void clickCartButton() {
        findElement("[class*='CartButton']").click();
    }

    private void openPLPPage() {
        driver.get("https://test.woahstork.com/cbdmarketplace");
    }

    private WebElement findElement(String cssLocator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
    }

}
