package projectactivity;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
public class Activity3 {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeClass(alwaysRun=true)
	public void driverSetup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.get("https://training-support.net/");
	}
	
	@Test
	public void testHeaderImg() {
		driver.get("https://crm.alchemy.hguy.co");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/scrm-footer-ui/div[1]/div/a[1]")));
		
		
		WebElement copyrightTex = driver.findElement(By.xpath("/html/body/app-root/scrm-footer-ui/div[1]/div/a[1]"));
		
		String text=copyrightTex.getText();
		System.out.println("Copyright text: " + text);
	}
	
	
	@AfterClass(alwaysRun=true)
	public void closeDriver() {
		driver.quit();
	}
	
	
	
}
 