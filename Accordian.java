package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Accordian {
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

            // Step 2: Click "Widgets" using text-based XPath
            WebElement widgetsOption = driver.findElement(By.xpath("//*[text()='Widgets']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetsOption);
            widgetsOption.click();
            Thread.sleep(1000); // Wait for the page to load

            // Step 3: Click "Accordian" option using text-based XPath
            WebElement accordianOption = driver.findElement(By.xpath("//*[text()='Accordian']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordianOption);
            accordianOption.click();
            Thread.sleep(1000); // Wait for the page to load

            // Step 4: Click the first box using the provided XPath
            WebElement section1Heading = driver.findElement(By.xpath("//*[@id='section1Heading']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Heading);
            section1Heading.click();
            Thread.sleep(1000); // Wait for the action to complete

            // Step 5: Click the second box using the provided XPath
            WebElement section2Heading = driver.findElement(By.xpath("//*[@id='section2Heading']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section2Heading);
            section2Heading.click();
            Thread.sleep(1000); // Wait for the action to complete

            // Step 6: Click the third box using the provided XPath
            WebElement section3Heading = driver.findElement(By.xpath("//*[@id='section3Heading']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section3Heading);
            section3Heading.click();
            Thread.sleep(1000); // Wait for the action to complete

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
