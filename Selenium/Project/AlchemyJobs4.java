package demon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlchemyJobs4 {
	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // Step 2: Navigate to the target URL
            driver.get("https://alchemy.hguy.co/jobs");

            // Step 3: Get all heading elements (h1, h2, h3, etc.) on the page
            List<WebElement> headings = driver.findElements(By.cssSelector("h1, h2, h3, h4, h5, h6"));

            // Step 4: Verify there are at least 2 headings
            if (headings.size() < 2) {
                System.out.println("FAIL: Less than 2 headings found on the page.");
                return;
            }

            // Step 5: Get the second heading text (index 1)
            String secondHeadingText = headings.get(1).getText().trim();
            System.out.println("Second heading found: \"" + secondHeadingText + "\"");

            // Step 6: Verify it matches the expected text exactly
            String expectedText = "Quia quis non";
            if (secondHeadingText.equals(expectedText)) {
                System.out.println("PASS: Second heading matches \"" + expectedText + "\"");
            } else {
                System.out.println("FAIL: Expected \"" + expectedText + "\" but got \"" + secondHeadingText + "\"");
            }

        } finally {
            // Step 7: Close the browser
            driver.quit();
        }
    }
}
