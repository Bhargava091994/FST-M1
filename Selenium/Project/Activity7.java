package projectactivity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
public class Activity7 {
	private WebDriver driver;
	 private WebDriverWait wait;
	
	@BeforeClass(alwaysRun=true)
	public void driverSetup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
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
		        Thread.sleep(10000);
		        
		        //WebElement moreButton = driver.findElement(By.xpath("/html/body/app-root/div/scrm-navbar-ui/scrm-base-navbar/div/nav/div[1]/scrm-menu-items-list/scrm-base-menu-items-list/ul/li/a/scrm-label"));
		        //moreButton.click();
		    
		

		        // Locate "Contacts" menu item (use robust XPath)
		        WebElement leads = driver.findElement(
		                    		  By.xpath("//span[text()='Leads']"));
		        //                     By.xpath("//a[contains(text(),'Documents')]"))
		   
	             //  Check Clickable
	                   wait.until(ExpectedConditions.elementToBeClickable(leads));

	                   Assert.assertTrue(leads.isEnabled(), 
	                           "leads menu is NOT clickable");

	                   System.out.println("leads exists and is clickable.");
	             
		           leads.click();
		           Thread.sleep(20000);
		           
		         List< WebElement > email =driver.findElements(
		        		             By.xpath("//table/tbody/tr/td[7]"));
		           for (WebElement e:email )
		           {
		           System.out.println(e.getText());
		           }
	}
		              
		           
	
	
	@AfterClass(alwaysRun=true)
	public void closeDriver() {
		driver.quit();
	}
	
	
	
}