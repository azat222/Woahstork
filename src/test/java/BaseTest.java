import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    // Local without selenium Grid
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,4);
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

//    Saucelabs
//    public static final String USERNAME = "azater777";
//    public static final String ACCESS_KEY = "f4e83c89-1138-48bf-b66d-3749fc1111a4";
//    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
