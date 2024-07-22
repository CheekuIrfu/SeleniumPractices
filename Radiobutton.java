package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Radiobutton {
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

            // Step 2: Click "Elements" using text-based XPath
            WebElement elementsOption = driver.findElement(By.xpath("//h5[text()='Elements']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsOption);
            Thread.sleep(1000); // Wait for the scroll to complete
            elementsOption.click();

            // Step 3: Click "Radio Button" option using text-based XPath
            WebElement radioButtonOption = driver.findElement(By.xpath("//span[text()='Radio Button']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButtonOption);
            Thread.sleep(1000); // Wait for the scroll to complete
            radioButtonOption.click();

            // Step 4: Click the "Yes" radio button using text-based XPath
            WebElement yesRadioButton = driver.findElement(By.xpath("//label[text()='Yes']"));
            yesRadioButton.click();
            Thread.sleep(1000); // Wait for the action to complete

            // Verify the "Yes" message
            WebElement yesMessage = driver.findElement(By.xpath("//p[text()='You have selected ']/span"));
            System.out.println("Message displayed: " + yesMessage.getText());

            // Step 5: Click the "Impressive" radio button using text-based XPath
            WebElement impressiveRadioButton = driver.findElement(By.xpath("//label[text()='Impressive']"));
            impressiveRadioButton.click();
            Thread.sleep(1000); // Wait for the action to complete

            // Verify the "Impressive" message
            WebElement impressiveMessage = driver.findElement(By.xpath("//p[text()='You have selected ']/span"));
            System.out.println("Message displayed: " + impressiveMessage.getText());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
