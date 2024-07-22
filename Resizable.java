package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Resizable {
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
            WebElement resizableMenuItem = driver.findElement(By.xpath("//span[text()='Resizable']"));
            js.executeScript("arguments[0].scrollIntoView(true);", resizableMenuItem);
            Thread.sleep(1000);
            resizableMenuItem.click();

            WebElement resizeHandle = driver.findElement(By.xpath("//*[@id='resizableBoxWithRestriction']/span"));
            WebElement resizableBox = driver.findElement(By.xpath("//*[@id='resizableBoxWithRestriction']"));

            Actions actions = new Actions(driver);
            actions.clickAndHold(resizeHandle).moveByOffset(100, 50).release().perform();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
