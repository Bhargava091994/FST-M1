package demon;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlchemyLMS1 {

public class VerifyWebsiteTitleTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        // If ChromeDriver is not on your PATH, set the path explicitly:
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Uncomment the line below to run headlessly (no browser UI):
        // options.addArguments("--headless", "--disable-gpu");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testVerifyWebsiteTitle() {

        // Step b: Navigate to the LMS URL
        driver.get("https://alchemy.hguy.co/lms");

        // Step c: Get the title of the website
        String actualTitle = driver.getTitle();
        System.out.println("Actual page title: '" + actualTitle + "'");

        // Step d: Assert the title matches exactly
        String expectedTitle = "Alchemy LMS \u2013 An LMS Application";
        assertEquals(
            "Title mismatch! Expected: '" + expectedTitle + "', Got: '" + actualTitle + "'",
            expectedTitle,
            actualTitle
        );

        System.out.println("✓ Title verified successfully: '" + actualTitle + "'");}

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }}}}