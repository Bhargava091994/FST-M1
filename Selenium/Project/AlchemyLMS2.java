package demon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

public class AlchemyLMS2 {
	 private WebDriver driver;
	    @BeforeClass
	    public void setUp() {
	        // If ChromeDriver is not on your PATH, set the path explicitly:
	        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");

	        driver = new ChromeDriver(options);
	    }
	    @org.testng.annotations.Test
	    public void testVerifyWebsiteHeading() {
	        driver.get("https://alchemy.hguy.co/lms");
	        WebElement headingElement = driver.findElement(By.tagName("h1"));
	        String actualHeading = headingElement.getText().trim();
	        System.out.println("Actual page heading: '" + actualHeading + "'");
	        String expectedHeading = "Learn from Industry Experts";
	        assertEquals(
	            "Heading mismatch! Expected: '" + expectedHeading + "', Got: '" + actualHeading + "'",
	            expectedHeading,
	            actualHeading
	        );

	        System.out.println("✓ Heading verified successfully: '" + actualHeading + "'");
	    }
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
