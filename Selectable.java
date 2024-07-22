package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selectable {
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

            // Step 2: Scroll down to interactions section and click using text-based XPath
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement interactionsSection = driver.findElement(By.xpath("//h5[text()='Interactions']"));
            js.executeScript("arguments[0].scrollIntoView(true);", interactionsSection);
            Thread.sleep(1000); // Wait for the scroll to complete
            interactionsSection.click();

            // Step 3: Scroll down to selectable menu item and click using text-based XPath
            WebElement selectableMenuItem = driver.findElement(By.xpath("//span[text()='Selectable']"));
            js.executeScript("arguments[0].scrollIntoView(true);", selectableMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            selectableMenuItem.click();

            // Step 4: Click list tab using text-based XPath
            WebElement listTab = driver.findElement(By.xpath("//a[text()='List']"));
            listTab.click();

            // Step 5: Click the first list box using text-based XPath and verify it's selected
            WebElement firstListBox = driver.findElement(By.xpath("//*[@id='verticalListContainer']/li[1]"));
            firstListBox.click();
            Thread.sleep(1000); // Wait to observe the action

            // Verify if the box is selected (turns blue)
            if (firstListBox.getAttribute("class").contains("active")) {
                System.out.println("List box is selected and turned blue.");
            } else {
                System.out.println("List box is not selected.");
            }

            // Step 6: Click grid tab using text-based XPath
            WebElement gridTab = driver.findElement(By.xpath("//a[text()='Grid']"));
            gridTab.click();

            // Step 7: Click the first grid box using text-based XPath and verify it's selected
            WebElement firstGridBox = driver.findElement(By.xpath("//*[@id='row1']/li[1]"));
            firstGridBox.click();
            Thread.sleep(1000); // Wait to observe the action

            // Verify if the box is selected (turns blue)
            if (firstGridBox.getAttribute("class").contains("active")) {
                System.out.println("Grid box is selected and turned blue.");
            } else {
                System.out.println("Grid box is not selected.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
