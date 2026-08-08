package demon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlchemyJobs5 {
    WebDriver driver = new ChromeDriver();{

    try {
        driver.get("https://alchemy.hguy.co/jobs");
        System.out.println("Opened URL: https://alchemy.hguy.co/jobs");
        WebElement navBar = driver.findElement(By.tagName("nav"));
        System.out.println("Navigation bar found.");
        WebElement jobsMenuItem = navBar.findElement(By.linkText("Jobs"));
        System.out.println("'Jobs' menu item found. Clicking...");
        jobsMenuItem.click();
        String pageTitle = driver.getTitle();
        System.out.println("Page title after navigation: \"" + pageTitle + "\"");

        String expectedTitle = "Jobs";
        if (pageTitle.contains(expectedTitle)) {
            System.out.println("PASS: Successfully navigated to the Jobs page. Title contains \"" + expectedTitle + "\"");
        } else {
            System.out.println("FAIL: Page title does not contain \"" + expectedTitle + "\". Actual title: \"" + pageTitle + "\"");
        }

    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
        e.printStackTrace();

    } finally {
        driver.quit();
        System.out.println("Browser closed.");
    }
}
}

