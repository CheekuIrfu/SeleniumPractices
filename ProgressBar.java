package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProgressBar {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement widgetsSection = driver.findElement(By.xpath("//h5[text()='Widgets']"));
            js.executeScript("arguments[0].scrollIntoView(true);", widgetsSection);
            Thread.sleep(6000);
            widgetsSection.click();

            WebElement progressBarMenuItem = driver.findElement(By.xpath("//span[text()='Progress Bar']"));
            js.executeScript("arguments[0].scrollIntoView(true);", progressBarMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            progressBarMenuItem.click();


            WebElement startStopButton = driver.findElement(By.xpath("//button[@id='startStopButton']"));
            startStopButton.click();


            WebElement progressBar = driver.findElement(By.xpath("//div[@id='progressBar']/div"));
            System.out.println("Initial Progress: " + progressBar.getText());

            for (int i = 0; i < 20; i++) {
                Thread.sleep(500);
                System.out.println("Current Progress: " + progressBar.getText());
            }
            startStopButton.click();
            System.out.println("Final Progress: " + progressBar.getText());

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
