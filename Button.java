package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Button {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-popup-blocking"); // Disable popup blocking

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open DEMOQA website
            driver.get("https://demoqa.com");

            // Click the "Elements" option
            WebElement elementsOption = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div"));
            elementsOption.click();

            // Wait for the page to load
            Thread.sleep(1000);

            // Click the "Buttons" option
            WebElement buttonsOption = driver.findElement(By.xpath("//*[@id='item-4']"));
            buttonsOption.click();

            // Wait for the page to load
            Thread.sleep(1000);

            // Perform a double click on the double click button
            WebElement doubleClickBtn = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
            Actions actions = new Actions(driver);
            actions.doubleClick(doubleClickBtn).perform();

            // Wait for the double click message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement doubleClickMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='doubleClickMessage']")));

            // Verify the double click message
            if (doubleClickMessage.isDisplayed()) {
                System.out.println("Double click message: " + doubleClickMessage.getText());
            } else {
                System.out.println("Double click message not displayed.");
            }

            // Perform a right click on the right click button
            WebElement rightClickBtn = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
            actions.contextClick(rightClickBtn).perform();

            // Wait for the right click message to appear
            WebElement rightClickMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightClickMessage']")));

            // Verify the right click message
            if (rightClickMessage.isDisplayed()) {
                System.out.println("Right click message: " + rightClickMessage.getText());
            } else {
                System.out.println("Right click message not displayed.");
            }

            // Perform a dynamic click on the dynamic click button
            WebElement dynamicClickBtn = driver.findElement(By.xpath("//*[@id='dynamicClickBtn']"));
            dynamicClickBtn.click();

            // Wait for the dynamic click message to appear
            WebElement dynamicClickMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicClickMessage']")));

            // Verify the dynamic click message
            if (dynamicClickMessage.isDisplayed()) {
                System.out.println("Dynamic click message: " + dynamicClickMessage.getText());
            } else {
                System.out.println("Dynamic click message not displayed.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
