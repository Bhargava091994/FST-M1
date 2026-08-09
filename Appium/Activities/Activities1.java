package Example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activities1 {
AppiumDriver driver;
	
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		File testApp = new File("src/test/resources/Calculator.apk");
			
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		driver = new AndroidDriver(serverURL,options);
	}
	
	
	@Test
	public void test() {
		WebElement numberNineBtn = driver.findElement(AppiumBy.accessibilityId("9"));
		numberNineBtn.click();
		
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul")).click();
		
		WebElement numberfiveBtn = driver.findElement(AppiumBy.accessibilityId("5"));
		numberfiveBtn.click();
		
		driver.findElement(AppiumBy.id("eq")).click();
		
		String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
				
		Assert.assertEquals(result,"45");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
