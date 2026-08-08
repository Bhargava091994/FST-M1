package demon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlchemyJobs9 {
	  WebDriver driver = new ChromeDriver();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
      String username = "root";
      String password = "pa$$w0rd";

      String jobTitle = "Automation Test Engineer";
      String jobDescription =
              "We are looking for an experienced Automation Test Engineer "
              + "to join our team.";
      String companyName = "ABC Technologies";
      String location = "Hyderabad";{

      try {
          driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
          driver.manage().window().maximize();
          WebElement usernameField = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("user_login")
                  )
          );
          usernameField.sendKeys(username);
          WebElement passwordField = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("user_pass")
                  )
          );
          passwordField.sendKeys(password);
          WebElement loginButton = wait.until(
                  ExpectedConditions.elementToBeClickable(
                          By.id("wp-submit")
                  )
          );
          loginButton.click();
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("wpbody")
                  )
          );

          System.out.println("Login successful.");

          // c. Locate left-hand menu and click "Job Listings"
          WebElement jobListingsMenu = wait.until(
                  ExpectedConditions.elementToBeClickable(
                          By.xpath("//div[@class='wp-menu-name' "
                                 + "and normalize-space()='Job Listings']")
                  )
          );

          jobListingsMenu.click();
          wait.until(
                  ExpectedConditions.urlContains("edit.php")
          );

          System.out.println("Job Listings page opened.");

          WebElement addNewButton = wait.until(
                  ExpectedConditions.elementToBeClickable(
                          By.xpath("//a[contains(@class,'page-title-action') "
                                 + "and normalize-space()='Add New']")
                  )
          );

          addNewButton.click();
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("title")
                  )
          );
          WebElement titleField = driver.findElement(By.id("title"));
          titleField.sendKeys(jobTitle);
          WebElement descriptionField = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("content")
                  )
          );

          descriptionField.click();
          try {

              WebElement editorFrame = driver.findElement(
                      By.cssSelector("iframe[id*='content']")
              );

              driver.switchTo().frame(editorFrame);

              WebElement editorBody = wait.until(
                      ExpectedConditions.visibilityOfElementLocated(
                              By.tagName("body")
                      )
              );

              editorBody.sendKeys(jobDescription);

              driver.switchTo().defaultContent();

          } catch (Exception e) {
              WebElement contentTextArea = driver.findElement(
                      By.id("content")
              );

              contentTextArea.sendKeys(jobDescription);
          }
          WebElement companyField = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("_company_name")
                  )
          );
          companyField.sendKeys(companyName);
          WebElement locationField = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("_job_location")
                  )
          );

          locationField.sendKeys(location);
          WebElement publishButton = wait.until(
                  ExpectedConditions.elementToBeClickable(
                          By.id("publish")
                  )
          );

          publishButton.click();
          wait.until(
                  ExpectedConditions.or(
                          ExpectedConditions.textToBePresentInElementLocated(
                                  By.id("message"),
                                  "published"
                          ),
                          ExpectedConditions.urlContains("post.php")
                  )
          );

          System.out.println("Job listing published successfully.");
          WebElement jobListingsLink = wait.until(
                  ExpectedConditions.elementToBeClickable(
                          By.xpath("//div[@class='wp-menu-name' "
                                 + "and normalize-space()='Job Listings']")
                  )
          );

          jobListingsLink.click();
          WebElement searchBox = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.id("post-search-input")
                  )
          );

          searchBox.clear();
          searchBox.sendKeys(jobTitle);

          WebElement searchButton = driver.findElement(
                  By.id("search-submit")
          );

          searchButton.click();
          WebElement createdJob = wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                          By.xpath("//a[normalize-space()='"
                                  + jobTitle + "']")
                  )
          );

          if (createdJob.isDisplayed()) {
              System.out.println(
                      "SUCCESS: Job listing '" + jobTitle
                      + "' was created successfully."
              );
          }

      } catch (Exception e) {

          System.out.println("Test failed.");
          e.printStackTrace();

      } finally {
          driver.quit();
      }
  }
}