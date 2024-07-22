package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicProperties {
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

            // Step 3: Scroll down to "Dynamic Properties" menu item and click using text-based XPath
            WebElement dynamicPropertiesMenuItem = driver.findElement(By.xpath("//span[text()='Dynamic Properties']"));
            js.executeScript("arguments[0].scrollIntoView(true);", dynamicPropertiesMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            dynamicPropertiesMenuItem.click();

            // Step 4: Wait for the "Color Change" button to be enabled and click it
            WebElement colorChangeButton = driver.findElement(By.xpath("//*[@id='colorChange']"));
            js.executeScript("arguments[0].scrollIntoView(true);", colorChangeButton);
            Thread.sleep(6000); // Wait for the button to change color
            colorChangeButton.click();
            Thread.sleep(2000); // Wait to observe the click action

            // Step 5: Wait for the "Visible After 5 Seconds" button to appear and click it
            WebElement visibleAfterButton = driver.findElement(By.xpath("//*[@id='visibleAfter']"));
            Thread.sleep(6000); // Wait for the button to become visible
            visibleAfterButton.click();
            Thread.sleep(2000); // Wait to observe the click action

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
