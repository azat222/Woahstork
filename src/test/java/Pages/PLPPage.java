package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PLPPage {

    WebDriver myDriver;

    public PLPPage(WebDriver myDriver) {
        this.myDriver = myDriver;
//        PageFactory.initElements(myDriver, this);
        WebDriverRunner.setWebDriver(myDriver);
    }

    SelenideElement checkoutElement = $("[class*='ButtonWrapper'] a");

    SelenideElement cartButton = $("[class*='CartButton']");

//    @FindBy(css = "[class*='ButtonWrapper'] a")
//    private WebElement checkoutElement;

//    @FindBy(css = "[class*='CartButton']")
//    private WebElement cartButton;

    public String getCheckoutButtonLabel(){
        return checkoutElement.getText();
    }

    public PLPPage clickCartButton() {
        cartButton.click();
        return this;
    }

    public PLPPage openPLPPage() {
        myDriver.get("https://test.woahstork.com/cbdmarketplace");
        return this;
    }
}
