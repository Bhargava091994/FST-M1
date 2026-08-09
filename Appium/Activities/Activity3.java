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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	UiAutomator2Options options;
	AndroidDriver driver;
	
	@BeforeClass
	public void setUP() throws MalformedURLException, URISyntaxException {
		File testApp = new File("src/test/resources/Calculator.apk");

		options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		driver = new AndroidDriver(serverURL,options);
	}
	
	@Test
	public void additionTest() {		
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		
		WebElement equalsToBtn = driver.findElement(AppiumBy.accessibilityId("equals"));
		equalsToBtn.click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		System.out.println("The result of addition is: " + result);
		
		Assert.assertEquals(result, "14");
	}
	
	@Test
	public void substractionTest() {		
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		System.out.println("The result of substraction is: " + result);
		
		Assert.assertEquals(result, "5");
	}
	
	
	@Test
	public void multiplicationTest() {		
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		System.out.println("The result of multiplication is: " + result);
		
		Assert.assertEquals(result, "500");
	}
	
	@Test
	public void divisionTest() {		
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("divide")).click();
		driver.findElement(AppiumBy.id("digit_2")).click();
		
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		
		System.out.println("The result of division is: " + result);
		
		Assert.assertEquals(result, "25");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
