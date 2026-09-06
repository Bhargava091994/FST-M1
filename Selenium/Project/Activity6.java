package projectactivity;

import java.time.Duration;

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

 
public class Activity6 {
	private WebDriver driver;
	 private WebDriverWait wait;
	
	@BeforeClass(alwaysRun=true)
	public void driverSetup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
		
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
		        
		        //WebElement moreButton = driver.findElement(By.xpath("/html/body/app-root/div/scrm-navbar-ui/scrm-base-navbar/div/nav/div[1]/scrm-menu-items-list/scrm-base-menu-items-list/ul/li/a/scrm-label"));
		        //moreButton.click();
		        
		      
		

		        // Locate "Contacts" menu item (use robust XPath)
		              WebElement contactsMenu = wait.until(
		                      ExpectedConditions.presenceOfElementLocated(
		                    		  By.xpath("/html/body/app-root/div/scrm-navbar-ui/scrm-base-navbar/div/nav/div[1]/ul/li[3]/scrm-menu-item/scrm-base-menu-item/div/span/scrm-menu-item-link/scrm-base-menu-item-link/a/span"))
		        //                     By.xpath("//a[contains(text(),'Documents')]"))
		                 
		              );
		              
		           



		           //  Check Exists
		              System.out.println("before contacts valid");
		       
		                   Assert.assertTrue(contactsMenu.isDisplayed(), 
		                           "contacts menu is NOT visible");
		                   
		                   System.out.println("after contacts valid");		                   

		                   //  Check Clickable
		                   wait.until(ExpectedConditions.elementToBeClickable(contactsMenu));

		                   Assert.assertTrue(contactsMenu.isEnabled(), 
		                           "contacts menu is NOT clickable");

		                   System.out.println("contacts menu exists and is clickable.");
		               }

	
	
	@AfterClass(alwaysRun=true)
	public void closeDriver() {
		driver.quit();
	}
	
	
	
}