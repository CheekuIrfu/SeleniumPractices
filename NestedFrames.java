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

public class NestedFrames {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait

        try {
            // Open google.com
            driver.get("https://www.google.com");

            // Open DEMOQA website
            driver.get("https://demoqa.com");

            // Open the Alerts, Frame & Windows section
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement alertsFrameWindows = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]")));
            alertsFrameWindows.click();

            // Navigate to alerts windows URL
            driver.get("https://demoqa.com/alertsWindows");

            // Click the Alerts, Frame & Windows option
            WebElement alertsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div/div[1]/div/div/div[3]/span/div/div[1]")));
            alertsOption.click();

            // Click the Nested Frames option
            WebElement nestedFramesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='item-3']")));
            nestedFramesOption.click();

            // Navigate to Nested Frames URL
            driver.get("https://demoqa.com/nestedframes");

            // Optionally, print the current URL
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
