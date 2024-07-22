package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DatePicker {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // Step 1: Open DEMOQA.com
            driver.get("https://demoqa.com");

            // Step 2: Scroll down to widgets section and click using text-based XPath
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement widgetsSection = driver.findElement(By.xpath("//h5[text()='Widgets']"));
            js.executeScript("arguments[0].scrollIntoView(true);", widgetsSection);
            Thread.sleep(1000); // Wait for the scroll to complete
            widgetsSection.click();

            // Step 3: Scroll down to date picker menu item and click using text-based XPath
            WebElement datePickerMenuItem = driver.findElement(By.xpath("//span[text()='Date Picker']"));
            js.executeScript("arguments[0].scrollIntoView(true);", datePickerMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            datePickerMenuItem.click();

            // Step 4: Change the current date in the select date option using text-based XPath
            WebElement dateInput = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
            dateInput.click();
            dateInput.clear();
            dateInput.sendKeys("07/21/2024"); // Enter the desired date
            Thread.sleep(1000); // Wait to observe the action

            // Step 5: Change the date and time in the date and time option using text-based XPath
            WebElement dateTimeInput = driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']"));
            dateTimeInput.click();
            dateTimeInput.clear();
            dateTimeInput.sendKeys("July 21, 2024 10:30 AM"); // Enter the desired date and time
            Thread.sleep(1000); // Wait to observe the action

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
