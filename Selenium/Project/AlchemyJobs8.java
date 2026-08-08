package demon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlchemyJobs8 {
	WebDriver driver = new ChromeDriver();

    // Explicit wait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));{

    try {

        // b. Navigate to WordPress admin login page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
        driver.manage().window().maximize();

        // c. Find username field and enter username
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("user_login")
                )
        );

        usernameField.sendKeys("root");

        // d. Find password field and enter password
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("user_pass")
                )
        );

        passwordField.sendKeys("pa$$w0rd");

        // e. Find login button and click
        WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("wp-submit")
                )
        );

        loginButton.click();

        // f. Verify that you have logged in
        wait.until(
                ExpectedConditions.urlContains("/wp-admin/")
        );

        // Verify WordPress Dashboard is displayed
        WebElement dashboard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("wpbody")
                )
        );

        if (dashboard.isDisplayed()) {
            System.out.println("Login successful!");
            System.out.println("Dashboard URL: " + driver.getCurrentUrl());
        } else {
            System.out.println("Login failed.");
        }

    } catch (Exception e) {

        System.out.println("Test failed.");
        e.printStackTrace();

    } finally {

        // g. Close the browser
        driver.quit();
    }
}
}
