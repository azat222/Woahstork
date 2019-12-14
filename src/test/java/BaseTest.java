import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
//    WebDriver driver;
    WebDriverWait wait;

    ThreadLocal<RemoteWebDriver> threadDriver;

    @BeforeMethod
    public void beforeMethodSetup() throws MalformedURLException {

        threadDriver = new ThreadLocal<RemoteWebDriver>();

        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
        switch (System.getProperty("browser")) {
            case "safari":
                dc.setBrowserName(DesiredCapabilities.safari().getBrowserName());
                break;
            case "chrome":
                dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
                break;
            case "firefox":
                dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
                break;
            default:
                dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
        }

        dc.setPlatform(Platform.MAC);


        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
        wait = new WebDriverWait(getDriver(),20);
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}



//   // browserstack
//    public static final String USERNAME = "azat33";
//    public static final String AUTOMATE_KEY = "LJ5VcJqAc4gFufHXTwtT";
//    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//
//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", "Edge");
//        caps.setCapability("browser_version", "17.0");
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("resolution", "1024x768");
//        caps.setCapability("name", "Bstack-[Java] Sample Test");
//
//        driver = new RemoteWebDriver(new URL(URL), caps);
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver,10);
//    }


//    @BeforeMethod
//    public void beforeMethodSetup() throws MalformedURLException {
//        String nodeURL = "http://localhost:4444/";
//
//        DesiredCapabilities caps = DesiredCapabilities.safari();
////        caps.setBrowserName("chrome");
//        caps.setPlatform(Platform.MAC);
//
//        driver = new RemoteWebDriver(new URL(nodeURL), caps);
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,4);
//        driver.manage().window().maximize();
//    }


