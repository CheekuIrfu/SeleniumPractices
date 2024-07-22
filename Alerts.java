package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alerts{
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

            // Step 3: Scroll down to "Alerts" menu item and click using text-based XPath
            WebElement alertsMenuItem = driver.findElement(By.xpath("//span[text()='Alerts']"));
            js.executeScript("arguments[0].scrollIntoView(true);", alertsMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            alertsMenuItem.click();

            // Step 4: Click the button to see alert and handle the alert
            WebElement alertButton = driver.findElement(By.xpath("//*[@id='alertButton']"));
            alertButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message: " + alert.getText()); // Should be "You clicked a button"
            alert.accept();
            Thread.sleep(1000); // Wait to observe the action

            // Step 5: Click the button to see timer alert and handle the alert
            WebElement timerAlertButton = driver.findElement(By.xpath("//*[@id='timerAlertButton']"));
            timerAlertButton.click();
            Thread.sleep(6000); // Wait for the alert to appear
            Alert timerAlert = driver.switchTo().alert();
            System.out.println("Alert message: " + timerAlert.getText()); // Should be "This alert appeared after 5 seconds"
            timerAlert.accept();
            Thread.sleep(1000); // Wait to observe the action

            // Step 6: Click the button to see confirm box and handle the alert
            WebElement confirmButton = driver.findElement(By.xpath("//*[@id='confirmButton']"));
            confirmButton.click();
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Alert message: " + confirmAlert.getText()); // Should be "Do you confirm action"
            confirmAlert.dismiss(); // Click cancel
            WebElement confirmResult = driver.findElement(By.xpath("//*[@id='confirmResult']"));
            System.out.println("Confirm result: " + confirmResult.getText()); // Should be "You selected Cancel"
            Thread.sleep(1000); // Wait to observe the action
            confirmButton.click();
            confirmAlert = driver.switchTo().alert();
            confirmAlert.accept(); // Click ok
            confirmResult = driver.findElement(By.xpath("//*[@id='confirmResult']"));
            System.out.println("Confirm result: " + confirmResult.getText()); // Should be "You selected Ok"
            Thread.sleep(1000); // Wait to observe the action

            // Step 7: Click the button to see prompt box and handle the alert
            WebElement promptButton = driver.findElement(By.xpath("//*[@id='promtButton']"));
            promptButton.click();
            Alert promptAlert = driver.switchTo().alert();
            System.out.println("Alert message: " + promptAlert.getText()); // Should be "Please enter your name"
            promptAlert.sendKeys("John Doe");
            promptAlert.accept();
            WebElement promptResult = driver.findElement(By.xpath("//*[@id='promptResult']"));
            System.out.println("Prompt result: " + promptResult.getText()); // Should be "You entered John Doe"
            Thread.sleep(1000); // Wait to observe the action

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
