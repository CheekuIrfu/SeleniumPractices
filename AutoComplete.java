package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoComplete {
            public static void main(String[] args) {
                // Setup ChromeOptions
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--remote-allow-origins=*");

                // Setup WebDriver
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                try {
                    // Step 1: Open DEMOQA.com
                    driver.get("https://demoqa.com");

                    // Step 2: Click "Widgets" using text-based XPath
                    WebElement widgetsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Widgets']")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetsOption);
                    widgetsOption.click();

                    // Step 3: Click "Auto Complete" option using text-based XPath
                    WebElement autoCompleteOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Auto Complete']")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", autoCompleteOption);
                    autoCompleteOption.click();

                    // Step 4: Enter the number in the multi-value box and clear it
                    WebElement autoCompleteMultipleBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='autoCompleteMultipleContainer']//input")));
                    autoCompleteMultipleBox.sendKeys("123");
                    wait.until(ExpectedConditions.textToBePresentInElementValue(autoCompleteMultipleBox, "123"));
                    autoCompleteMultipleBox.clear();

                    // Step 5: Enter the number in the single-value box and clear it
                    WebElement autoCompleteSingleBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='autoCompleteSingleContainer']//input")));
                    autoCompleteSingleBox.sendKeys("456");
                    wait.until(ExpectedConditions.textToBePresentInElementValue(autoCompleteSingleBox, "456"));
                    autoCompleteSingleBox.clear();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // Close the browser
                    driver.quit();
                }
            }}
