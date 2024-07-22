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
import java.util.concurrent.TimeUnit;

public class Frames {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait

        try {
            // Open google.com
            driver.get("https://www.google.com");

            // Open DEMOQA website
            driver.get("https://demoqa.com");

            // Click the "Alerts, Frame & Windows" option
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement alertsFrameWindowsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]")));
            alertsFrameWindowsOption.click();

            // Click the "Frames" option
            WebElement framesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-2']")));
            framesOption.click();

            // Verify that we navigated to the content using the specified XPath
            WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div/div/div/div[2]")));
            System.out.println("Navigated to the Frames page and found the content.");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
