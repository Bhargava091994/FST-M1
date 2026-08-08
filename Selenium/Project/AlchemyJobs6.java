package demon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlchemyJobs6 {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));{
    try {
        driver.get("https://alchemyjobs.com/");
        driver.manage().window().maximize();
        WebElement jobsLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Jobs")
                )
        );
        jobsLink.click();
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("search")
                )
        );
        searchBox.sendKeys("Software Engineer");
        WebElement searchButton = driver.findElement(
                By.xpath("//button[contains(text(),'Search')]")
        );
        searchButton.click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".job-listing")
                )
        );
        WebElement firstJob = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".job-listing")
                )
        );
        firstJob.click();
        WebElement applyButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Apply')]")
                )
        );
        applyButton.click();
        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".email")
                )
        );
        System.out.println("Application Email: " + email.getText());

    } finally {
        driver.quit();
    }
}
}
