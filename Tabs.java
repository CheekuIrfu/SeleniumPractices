package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tabs {
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

            // Step 3: Scroll down to tabs menu item and click using text-based XPath
            WebElement tabsMenuItem = driver.findElement(By.xpath("//span[text()='Tabs']"));
            js.executeScript("arguments[0].scrollIntoView(true);", tabsMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            tabsMenuItem.click();

            // Step 4: Click the "What" tab using text-based XPath
            WebElement whatTab = driver.findElement(By.xpath("//*[@id='demo-tab-what']"));
            whatTab.click();
            Thread.sleep(1000); // Wait to observe the action

            // Step 5: Click the "Origin" tab using text-based XPath
            WebElement originTab = driver.findElement(By.xpath("//*[@id='demo-tab-origin']"));
            originTab.click();
            Thread.sleep(1000); // Wait to observe the action

            // Step 6: Click the "Use" tab using text-based XPath
            WebElement useTab = driver.findElement(By.xpath("//*[@id='demo-tab-use']"));
            useTab.click();
            Thread.sleep(1000); // Wait to observe the action

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
