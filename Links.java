package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Links {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait

        try {
            // Open DEMOQA website
            driver.get("https://demoqa.com");

            // Click the "Elements" option
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement elementsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div")));
            elementsOption.click();

            // Click the "Links" option
            WebElement linksOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-5']")));
            linksOption.click();

            // Click the "Home" link
            WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='simpleLink']")));
            homeLink.click();

            // Wait for the page to load and navigate back to the DEMOQA home page
            switchToNewTab(driver);
            Thread.sleep(3000);  // Wait for the page to load
            driver.close();  // Close the new tab
            driver.switchTo().window(driver.getWindowHandles().iterator().next());  // Switch back to the original tab
            driver.navigate().to("https://demoqa.com/");

            // Navigate to Elements and Links again
            elementsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div")));
            elementsOption.click();
            linksOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-5']")));
            linksOption.click();

            // Click the "Created" link
            WebElement createdLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='created']")));
            createdLink.click();
            System.out.println("Clicked the 'Created' link.");
            // Reload the page
            Thread.sleep(3000);  // Wait for the action to complete
            driver.navigate().refresh();

            // Click the "No Content" link
            WebElement noContentLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='no-content']")));
            noContentLink.click();
            System.out.println("Clicked the 'No Content' link.");
            // Reload the page
            Thread.sleep(3000);  // Wait for the action to complete
            driver.navigate().refresh();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void switchToNewTab(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String originalWindow = driver.getWindowHandle();

        while (iterator.hasNext()) {
            String currentWindow = iterator.next();
            if (!currentWindow.equals(originalWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }
    }
}
