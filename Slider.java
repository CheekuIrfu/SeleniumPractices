package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Slider {
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
            Thread.sleep(1000);
            widgetsSection.click();

            WebElement sliderMenuItem = driver.findElement(By.xpath("//span[text()='Slider']"));
            js.executeScript("arguments[0].scrollIntoView(true);", sliderMenuItem);
            Thread.sleep(1000);
            sliderMenuItem.click();

            WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
            Actions actions = new Actions(driver);

            actions.clickAndHold(slider).moveByOffset(30, 0).release().perform();
            Thread.sleep(2000);

            actions.clickAndHold(slider).moveByOffset(-30, 0).release().perform();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
