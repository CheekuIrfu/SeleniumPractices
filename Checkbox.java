package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkbox {
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

            // Click the "Check Box" option
            WebElement checkBoxOption = driver.findElement(By.xpath("//*[@id='item-1']"));
            checkBoxOption.click();

            // Expand the "Home" checkbox
            WebElement homeCheckbox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button"));
            homeCheckbox.click();

            // Click the "Desktop" checkbox
            WebElement desktopCheckbox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/span/label/span[3]"));
            desktopCheckbox.click();

            // Click the "Documents" checkbox
            WebElement documentsCheckbox = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/span/label/span[3]"));
            documentsCheckbox.click();

            // Wait to see the result
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
