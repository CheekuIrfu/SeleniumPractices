package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SelectMenu{
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

            // Step 3: Scroll down to select menu item and click using text-based XPath
            WebElement selectMenuItem = driver.findElement(By.xpath("//span[text()='Select Menu']"));
            js.executeScript("arguments[0].scrollIntoView(true);", selectMenuItem);
            Thread.sleep(1000); // Wait for the scroll to complete
            selectMenuItem.click();

            // Step 4: Click the select option box in "Select Value" using text-based XPath
            WebElement selectValueBox = driver.findElement(By.xpath("//*[@id='withOptGroup']/div/div[1]"));
            selectValueBox.click();
            // Select "Group 1, Option 1"
            WebElement group1Option1 = driver.findElement(By.xpath("//div[text()='Group 1, option 1']"));
            group1Option1.click();
            Thread.sleep(1000); // Wait to observe the action

            // Step 5: Click the select title option in "Select One" using text-based XPath
            WebElement selectOneBox = driver.findElement(By.xpath("//*[@id='selectOne']/div/div[1]"));
            selectOneBox.click();
            // Select "Dr."
            WebElement drOption = driver.findElement(By.xpath("//div[text()='Dr.']"));
            drOption.click();
            Thread.sleep(1000); // Wait to observe the action

            // Step 6: Click the select option in "Multi Select Dropdown" using text-based XPath
            WebElement multiSelectBox = driver.findElement(By.xpath("//*[@id='selectMenuContainer']/div[7]/div/div/div/div[1]"));
            multiSelectBox.click();
            // Select "Green"
            WebElement greenOption = driver.findElement(By.xpath("//div[text()='Green']"));
            greenOption.click();
            Thread.sleep(1000); // Wait to observe the action

            // Step 7: Select "Opel" in "Standard Multi Select" using text-based XPath
            WebElement opelOption = driver.findElement(By.xpath("//option[text()='Opel']"));
            opelOption.click();
            Thread.sleep(1000); // Wait to observe the action

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
