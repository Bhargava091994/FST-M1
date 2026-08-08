package demon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlchemyJobs3 {
	private WebDriver driver;
    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Test
    public void testGetHeaderImageUrl() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement headerImage = driver.findElement(By.cssSelector("header img"));
        String imageUrl = headerImage.getAttribute("src");
        System.out.println("Header Image URL: " + imageUrl);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}