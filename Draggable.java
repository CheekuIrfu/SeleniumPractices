package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Draggable {
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
            WebElement interactionsSection = driver.findElement(By.xpath("//h5[text()='Interactions']"));
            js.executeScript("arguments[0].scrollIntoView(true);", interactionsSection);
            Thread.sleep(1000);
            interactionsSection.click();
            WebElement draggableMenuItem = driver.findElement(By.xpath("//span[text()='Dragabble']"));
            js.executeScript("arguments[0].scrollIntoView(true);", draggableMenuItem);
            Thread.sleep(1000);
            draggableMenuItem.click();

            WebElement axisRestrictedTab = driver.findElement(By.xpath("//a[text()='Axis Restricted']"));
            axisRestrictedTab.click();

            WebElement restrictedXBox = driver.findElement(By.xpath("//*[@id='restrictedX']"));
            WebElement restrictedYBox = driver.findElement(By.xpath("//*[@id='restrictedY']"));
            Actions actions = new Actions(driver);

            actions.dragAndDropBy(restrictedXBox, 100, 0).perform();
            Thread.sleep(2000);
            actions.dragAndDropBy(restrictedYBox, 0, 100).perform();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
