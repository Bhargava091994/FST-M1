package demon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlchemyJobs7 {
	 // a. Open a browser
    WebDriver driver = new ChromeDriver();

    // Create explicit wait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // Job details
    String jobTitle = "Automation Test Engineer";
    String companyName = "ABC Technologies";
    String location = "Hyderabad";
    String description = "We are looking for an experienced Automation Test Engineer."; {

    try {

        // b. Navigate to Alchemy Jobs
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();

        // c. Locate navigation menu and click "Post a Job"
        WebElement postJobLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Post a Job")
                )
        );

        postJobLink.click();

        // d. Fill in the job details

        // Job Title
        WebElement jobTitleField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("job_title")
                )
        );
        jobTitleField.sendKeys(jobTitle);

        // Description
        WebElement descriptionField = driver.findElement(
                By.id("job_description")
        );
        descriptionField.sendKeys(description);

        // Company Name
        WebElement companyNameField = driver.findElement(
                By.id("company_name")
        );
        companyNameField.sendKeys(companyName);

        // Location
        WebElement locationField = driver.findElement(
                By.id("job_location")
        );
        locationField.sendKeys(location);

        // Click Preview
        WebElement previewButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.name("submit_job")
                )
        );

        previewButton.click();

        // e. Click "Submit Listing"
        WebElement submitListingButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.name("submit_job")
                )
        );

        submitListingButton.click();

        // f. Verify that the job listing was posted
        wait.until(
                ExpectedConditions.urlContains("/jobs/")
        );

        // Verify that the job title is displayed
        WebElement postedJobTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[contains(text(),'" + jobTitle + "')]")
                )
        );

        if (postedJobTitle.isDisplayed()) {
            System.out.println("Job listing posted successfully.");
            System.out.println("Job Title: " + postedJobTitle.getText());
        } else {
            System.out.println("Job listing was not posted.");
        }

        // Additional verification: navigate to Jobs page
        driver.get("https://alchemy.hguy.co/jobs/");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'" + jobTitle + "')]")
                )
        );

        System.out.println("Job listing verified on Jobs page.");

    } catch (Exception e) {

        System.out.println("Test failed.");
        e.printStackTrace();

    } finally {

        // g. Close the browser
        driver.quit();
    }
}
}