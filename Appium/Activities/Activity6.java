package Example;


import static org.testng.Assert.assertTrue;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	UiAutomator2Options options;
	AndroidDriver driver;
	Action action;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUP() throws MalformedURLException, URISyntaxException {
		options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		driver = new AndroidDriver(serverURL, options);
		action = new Action();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@DataProvider(name="coordinates")
	public Object[][] inputValues(){
		Point start = new Point(540,1776);
		Point end_75 = new Point(720,1776);
		Point end_25 = new Point(365,1776);
		
		return new Object[][] {
			{start,end_75,"75%"},
			{start,end_25,"25%"}
		};
	}
	
	@Test(dataProvider="coordinates")
	public void testGestures(Point start, Point end , String value) {	
		driver.get("https://training-support.net/webelements/sliders");

		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
		
		action.doSwipe(driver, 2000, start, end);
		
		String volumeText = driver
				.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
				.getText();
	 
		assertTrue(volumeText.contains(value));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
