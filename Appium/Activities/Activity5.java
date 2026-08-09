package Example;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	 AndroidDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() throws Exception {

	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("Android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.google.android.apps.messaging");
	        options.setAppActivity(".ui.ConversationListActivity");

	        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

	        driver = new AndroidDriver(serverURL, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    @Test
	    public void sendMessage() {

	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.id("start_chat_fab"))).click();

	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.EditText")))
	                .sendKeys("8076957648");

	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath(
	                        "//android.view.View[@resource-id=\"ContactSuggestionList\"]/android.view.View")))
	                .click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                AppiumBy.id("compose_message_text")))
	                .sendKeys("Hello from Appium");

	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.accessibilityId("Send SMS")))
	                .click();

	        String message=driver.findElement(
	        	    AppiumBy.androidUIAutomator(
	        	            "new UiSelector().text(\"Hello from Appium\")"
	        	        )
	        	    ).getText();

	        Assert.assertEquals(message, "Hello from Appium");
	    }

	    @AfterClass
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
