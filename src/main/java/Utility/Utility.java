package Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

//import java.util.NoSuchElementException;
import io.appium.java_client.android.AndroidDriver;

//import org.openqa.selenium.support.ui.FluentWait;

public class Utility {
	
	
	/*    FluentWait<AndroidDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingInSeconds))
                .ignoring(NoSuchElementException.class);

        if (type.equalsIgnoreCase("id")) {
			return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(key)));
       } else if (type.equalsIgnoreCase("xpath")) {
    	   return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));
       } else if (type.equalsIgnoreCase("lnktxt")) {
    	   return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(key)));
       } else if (type.equalsIgnoreCase("name")) {
    	   return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(key)));
       } else if (type.equalsIgnoreCase("partlnktxt")) {
    	   return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(key)));
       } else if (type.equalsIgnoreCase("css")) {
    	   return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(key)));
       } else if (type.equalsIgnoreCase("tagname")) {
    	   return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(key)));
       } else {
    	   return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(key)));  
       }

}*/


public static WebElement fluentWait(AndroidDriver driver,String key, String type, int duration, int pollingInMilliSec ) {
    
    System.out.println("Under fluent wait for: " + key);
    Wait<AndroidDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(duration))
            .pollingEvery(Duration.ofSeconds(pollingInMilliSec))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    By locator;
    switch (type.toLowerCase()) {
        case "id":
            locator = By.id(key);
            break;
        case "xpath":
            locator = By.xpath(key);
            break;
        case "lnktxt":
            locator = By.linkText(key);
            break;
        case "name":
            locator = By.name(key);
            break;
        case "partlnktxt":
            locator = By.partialLinkText(key);
            break;
        case "css":
            locator = By.cssSelector(key);
            break;
        case "tagname":
            locator = By.tagName(key);
            break;
        default:
            locator = By.xpath(key); // Default to XPath if no match
            break;
    }

    return fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
}
}