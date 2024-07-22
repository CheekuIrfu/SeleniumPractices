import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ToolTips {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Open google.com
            driver.get("https://www.google.com");

            // Step 2: Open the demoqa.com URL
            driver.get("https://demoqa.com/");

            // Step 3: Click and open the Widgets option
            WebElement widgetsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[4]")));
            widgetsOption.click();

            // Step 4: Click and open the Tool Tips option
            WebElement toolTipsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-6']")));
            toolTipsOption.click();

            // Step 5: Show the button with the specified xpath
            WebElement toolTipButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='toolTipButton']")));
            System.out.println("Tool Tip Button displayed: " + toolTipButton.isDisplayed());

            // Step 6: Show the textbox with the specified xpath
            WebElement toolTipTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='toolTipTextField']")));
            System.out.println("Tool Tip Text Field displayed: " + toolTipTextField.isDisplayed());

            // Step 7: Show the text content with the specified xpath
            WebElement texToolTopContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='texToolTopContainer']")));
            System.out.println("Text Content displayed: " + texToolTopContainer.isDisplayed());

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
