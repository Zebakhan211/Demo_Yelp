package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.LoginPO;
import pageObjects.SearchPO;
import Utility.Utility;

public class APKInstall {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "samsung SM-A305F");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.yelp.android");
        capabilities.setCapability("appActivity", "com.yelp.android.home.ui.RootSingleActivity");
        capabilities.setCapability("autoGrantPermissions", true);

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        driver = new AndroidDriver(url, capabilities);
        System.out.println("Application started");
    }

    @Test
    public void testAutoLoginSkip() {
        Utility.fluentWait(driver, LoginPO.cancelAutoLogin_xpath, "xpath", 10, 1).click();
        Utility.fluentWait(driver, LoginPO.autoLoginClose_xpath, "xpath", 5, 1).click();
        Utility.fluentWait(driver, LoginPO.sendOkay_xpath, "xpath", 5, 1).click();
        Utility.fluentWait(driver, LoginPO.skip_id, "id", 5, 1).click();
        
        
    }
    
    @Test(dependsOnMethods = "testAutoLoginSkip")
    public void sortRestaurant() throws InterruptedException  {
    	Utility.fluentWait(driver, SearchPO.restaurant_xpath, "xpath", 10, 1).click();
    	Utility.fluentWait(driver, SearchPO.sort_xpath, "xpath", 10, 1).click();
    	Utility.fluentWait(driver, SearchPO.distance_xpath, "xpath", 10, 1).click();
    	Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
