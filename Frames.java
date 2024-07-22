package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // Step 1: Open DEMOQA.com
            driver.get("https://demoqa.com");

            // Step 2: Click "Alerts, Frame & Windows" using text-based XPath
            WebElement alertsFramesWindowsOption = driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertsFramesWindowsOption);
            alertsFramesWindowsOption.click();
            Thread.sleep(1000); // Wait for the page to load

            // Step 3: Click "Frames" option using text-based XPath
            WebElement framesOption = driver.findElement(By.xpath("//*[text()='Frames']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", framesOption);
            framesOption.click();
            Thread.sleep(1000); // Wait for the page to load

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
