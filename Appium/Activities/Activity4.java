package Example;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	UiAutomator2Options options;
	AndroidDriver driver;
	
	@BeforeClass
	public void setUP() throws MalformedURLException, URISyntaxException {
		options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		driver = new AndroidDriver(serverURL, options);
	}
	
	@Test
	public void testGestures() {
		driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
		
		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@text='First name']")).sendKeys("Aditya");
		
		driver.findElement(AppiumBy.xpath(""
				+ "//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
		
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='+1']"))
	      .sendKeys("999148292");
	       
	    driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button")).click();
	        
	        String result = driver.findElement(AppiumBy.id("com.google.android.contacts:id/large_title")).getText();
	        
	        Assert.assertEquals(result, "Aditya Varma");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
