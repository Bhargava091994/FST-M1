package activities;

import java.io.FileReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class TestActivity10 {
	private WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void driverSetup() {
		driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/simple-form");
	}
	
	@DataProvider(name="form-data")
	public static Object[][] formData() throws Exception {
			CSVReader reader = new CSVReader(new FileReader("src/test/resources/input.csv"));
			
			reader.skip(1);
			
			List<String[]> allRows = reader.readAll();
			
			Object data[][] = new Object[allRows.size()][];
			
			for(int i=0;i<allRows.size();i++) {
				data[i] = allRows.get(i);
			}
			
			reader.close();
						
		    return data;
	}
	
	@Test(dataProvider="form-data")
	public void form(String[] rows) throws InterruptedException {
		driver.findElement(By.id("full-name")).sendKeys(rows[0]);
		driver.findElement(By.id("email")).sendKeys(rows[1]);
		driver.findElement(By.name("event-date")).sendKeys(rows[2]);
		driver.findElement(By.id("additional-details")).sendKeys(rows[3]);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(1000);
		
		String message = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(message, "Your event has been scheduled!");
		
		driver.navigate().refresh();		
	}
	
	@AfterClass(alwaysRun=true)
	public void closeDriver() {
		driver.quit();
	}
}
