package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sortable {
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

            WebElement sortableMenuItem = driver.findElement(By.xpath("//span[text()='Sortable']"));
            js.executeScript("arguments[0].scrollIntoView(true);", sortableMenuItem);
            Thread.sleep(1000);
            sortableMenuItem.click();

            // Step 4: Click list tab using text-based XPath
            WebElement listTab = driver.findElement(By.xpath("//a[text()='List']"));
            listTab.click();
            Thread.sleep(1000); // Wait to observe the action

            // Verify the list view is displayed
            WebElement listView = driver.findElement(By.xpath("//*[@id='demo-tab-list']"));
            if (listView.isDisplayed()) {
                System.out.println("List view is displayed with boxes.");
            }

            // Step 5: Click grid tab using text-based XPath
            WebElement gridTab = driver.findElement(By.xpath("//a[text()='Grid']"));
            gridTab.click();
            Thread.sleep(1000); // Wait to observe the action

            // Verify the grid view is displayed
            WebElement gridView = driver.findElement(By.xpath("//*[@id='demo-tab-grid']"));
            if (gridView.isDisplayed()) {
                System.out.println("Grid view is displayed with boxes.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
