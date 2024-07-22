package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class UploadAndDownload {
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

            // Step 2: Scroll down to "Elements" section and click using text-based XPath
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement elementsSection = driver.findElement(By.xpath("//h5[text()='Elements']"));
            js.executeScript("arguments[0].scrollIntoView(true);", elementsSection);
            Thread.sleep(1000); // Wait for the scroll to complete
            elementsSection.click();

            // Step 3: Scroll down to "Upload and Download" menu item and click using text-based XPath
            WebElement uploadDownloadMenuItem = driver.findElement(By.xpath("//span[text()='Upload and Download']"));
            js.executeScript("arguments[0].scrollIntoView(true);", uploadDownloadMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            uploadDownloadMenuItem.click();

            // Step 4: Click the "Choose File" button and upload an image file from the desktop
            WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='uploadFile']"));
            File file = new File("C:/path/to/your/image.jpg"); // Update the path to your image file
            chooseFileButton.sendKeys(file.getAbsolutePath());
            Thread.sleep(2000); // Wait for the file to upload

            // Step 5: Click the "Download" button to download an image file
            WebElement downloadButton = driver.findElement(By.xpath("//a[@id='downloadButton']"));
            downloadButton.click();
            Thread.sleep(5000); // Wait for the file to download

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
