package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Radiobutton{
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open DEMOQA website
            driver.get("https://demoqa.com");

            // Click the "Elements" option
            WebElement elementsOption = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div"));
            elementsOption.click();

            // Click the "Radio Button" option
            WebElement radioButtonOption = driver.findElement(By.xpath("//*[@id='item-2']"));
            radioButtonOption.click();

            // Locate the group div for radio buttons
            WebElement radioGroupDiv = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[2]/div[2]"));

            // Click the "Yes" radio button
            WebElement yesRadioButton = radioGroupDiv.findElement(By.xpath("./div[2]/label"));
            yesRadioButton.click();
            printSelectionMessage("Yes");

            // Click the "Impressive" radio button
            WebElement impressiveRadioButton = radioGroupDiv.findElement(By.xpath("./div[3]/label"));
            impressiveRadioButton.click();
            printSelectionMessage("Impressive");

        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to print the selection message
    public static void printSelectionMessage(String selection) {
        System.out.println("Message displayed: " + selection);
    }
}
