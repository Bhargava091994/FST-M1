package projectactivity;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
public class Activity5 {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeClass(alwaysRun=true)
	public void driverSetup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	
	@Test
	public void loginTest() {
		driver.get("https://crm.alchemy.hguy.co");
				

		// Locate username field and enter value
		        WebElement username =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/scrm-login-ui/div/form/div[2]/div/div[1]/input")));
		        username.sendKeys("admin");

		        // Locate password field and enter value
		        WebElement password = driver.findElement(By.xpath("/html/body/app-root/div/scrm-login-ui/div/form/div[2]/div/div[2]/input"));
		        password.sendKeys("5Nx#I6BK%r3$8vz0ch");

		        // Click login button
		        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		        loginButton.click();


		     // Locate Navigation Menu (update locator if needed)
		             WebElement navMenu = driver.findElement(By.cssSelector("nav"));

		        // Get color (background-color)
		               String colorValue = navMenu.getCssValue("background-color");

		               // Convert to HEX (optional)
		               String hexColor = Color.fromString(colorValue).asHex();

		               // Print values
		               System.out.println("RGBA Color: " + colorValue);
		               System.out.println("HEX Color: " + hexColor);


	}
	
	
	@AfterClass(alwaysRun=true)
	public void closeDriver() {
		driver.quit();
	}
	
	
	
}