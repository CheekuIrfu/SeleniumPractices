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
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserWindows {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait

        try {
            driver.get("https://demoqa.com");

            // First flow: Open DEMOQA, click tabButton
            navigateToDemoQA(driver);
            performAction(driver, "//*[@id='tabButton']");
            System.out.println("Clicked the 'tabButton'.");

            // Second flow: Open DEMOQA, click windowButton
            navigateToDemoQA(driver);
            performAction(driver, "//*[@id='windowButton']");
            System.out.println("Clicked the 'windowButton'.");

            // Third flow: Open DEMOQA, click messageWindowButton
            navigateToDemoQA(driver);
            performAction(driver, "//*[@id='messageWindowButton']");
            System.out.println("Clicked the 'messageWindowButton'.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void navigateToDemoQA(WebDriver driver) throws InterruptedException {
        driver.get("https://demoqa.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click "Alert, Frame & Windows"
        WebElement mainOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div/div[1]/div/div/div[3]/span/div/div[1]")));
        mainOption.click();

        // Click "Browser Windows"
        WebElement subOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-0']")));
        subOption.click();
    }

    private static void performAction(WebDriver driver, String xpath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        button.click();

        // Switch to the new tab and wait for the page to load
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(3000);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(originalWindow);
    }
}
