package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ModalDialogs {
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

            // Step 2: Scroll down to "Alerts, Frame & Windows" section and click using text-based XPath
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement alertsFrameWindowsSection = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
            js.executeScript("arguments[0].scrollIntoView(true);", alertsFrameWindowsSection);
            Thread.sleep(1000); // Wait for the scroll to complete
            alertsFrameWindowsSection.click();

            // Step 3: Scroll down to "Modal Dialogs" menu item and click using text-based XPath
            WebElement modalDialogsMenuItem = driver.findElement(By.xpath("//span[text()='Modal Dialogs']"));
            js.executeScript("arguments[0].scrollIntoView(true);", modalDialogsMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            modalDialogsMenuItem.click();

            // Step 4: Click the button to show small modal
            WebElement smallModalButton = driver.findElement(By.xpath("//button[text()='Small modal']"));
            smallModalButton.click();
            Thread.sleep(1000); // Wait for the modal to appear

            // Verify the small modal is displayed and then close it
            WebElement smallModalHeader = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='modal-header']/div[@id='example-modal-sizes-title-sm']"));
            System.out.println("Small modal header: " + smallModalHeader.getText());
            WebElement smallModalCloseButton = driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Close']"));
            smallModalCloseButton.click();
            Thread.sleep(1000); // Wait for the modal to close

            // Step 5: Click the button to show large modal
            WebElement largeModalButton = driver.findElement(By.xpath("//button[text()='Large modal']"));
            largeModalButton.click();
            Thread.sleep(1000); // Wait for the modal to appear

            // Verify the large modal is displayed and then close it
            WebElement largeModalHeader = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='modal-header']/div[@id='example-modal-sizes-title-lg']"));
            System.out.println("Large modal header: " + largeModalHeader.getText());
            WebElement largeModalCloseButton = driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Close']"));
            largeModalCloseButton.click();
            Thread.sleep(1000); // Wait for the modal to close

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
